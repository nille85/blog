/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.post;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.AuthorService;
import be.nille.blog.domain.author.Name;
import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.domain.post.Comment;
import be.nille.blog.domain.post.Content;
import be.nille.blog.domain.post.Post;
import be.nille.blog.domain.post.PostService;
import be.nille.blog.mongo.author.AuthorDocument;
import be.nille.blog.mongo.author.MongoAuthorService;
import be.nille.blog.mongo.category.CategoryDocument;
import be.nille.blog.mongo.category.MongoCategoryService;
import be.nille.blog.service.PageInfo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class MongoPostServiceTest {
    
     private  MongoDatabase database;
    
    @Before
    public void setup(){
        final String url = System.getenv("MONGO_URL");
        MongoClient client = new MongoClient(
                new MongoClientURI(url)
        );
        database = client.getDatabase("openid-connect");
       
        
    }
    
    @Test
    public void findByPage(){
        PostService postService = new MongoPostService(database);
        List<Post> posts = postService.findByPageInfo(new PageInfo(10));
        posts.forEach(p -> log.debug(p.toString()));

    }
    
    @Ignore
    public  void addComment(){
        PostService postService = new MongoPostService(database);
        Post post = postService.findPostById("589f1de7df69b218cc340654");
        log.debug(post.toString());
        post.addComment(new Comment("Jack", "does this work?"));
        Post updated = postService.save(post);
        log.debug(updated.toString());
    }
    
    @Ignore
    public void testSave(){
        AuthorService authorService = new MongoAuthorService(database);
        CategoryService categoryService = new MongoCategoryService(database);
        PostService postService = new MongoPostService(database);
        
        Author author = authorService.save(new Author(new Name("Jack","TheRipper"),"ripper@ripped.de", "password"));
        log.debug(author.toString());
        Category category = categoryService.save(new Category("OracleDd"));
        log.debug(category.toString());
        for(int i=1;i<=20;i++){
            Post post = new Post(category, author, new Content("title " + i, "text " + i));
            post.addComment(new Comment("tester","my comment"));
            Post saved = postService.save(post);
            log.debug(saved.toString());
        }
          
    }
    
   
}
