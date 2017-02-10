/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.post;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.DAuthor;
import be.nille.blog.domain.author.Name;
import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.category.DCategory;
import be.nille.blog.domain.post.Content;
import be.nille.blog.domain.post.Post;
import be.nille.blog.mongo.author.AuthorDocument;
import be.nille.blog.mongo.category.CategoryDocument;
import be.nille.blog.mongo.category.MongoCategoryService;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Before;
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
    public void testInsert(){
        ObjectId author = insertAuthor();
        
        
        
        Category category = new MongoCategoryService(database).findAll().get(0);
        log.debug(category.toString());
        
        /*
        for(int i=1;i<=20;i++){
            Post post = new DPost(category, author, new Content("title " + i, "text " + i));
            dataStore.save(post);
        }
        */
        
        
        
    }
    
    private ObjectId insertAuthor(){
        MongoCollection authorCollection = database.getCollection("author");
        
        Author author = new DAuthor(new Name("Jack","TheRipper"),"ripper@ripped.de", "password");
        AuthorDocument aDocument = new AuthorDocument(author);
        Document document = aDocument.toDocument();
        authorCollection.insertOne(document);
        return ((ObjectId) document.get("_id"));
        
    }
    
    private ObjectId insertCategory(){
        MongoCollection categoryCollection = database.getCollection("category");
        Category category = new DCategory("Lambda Calculus 2");
        CategoryDocument cd = new CategoryDocument(category);
        
        Document categoryDocument = cd.toDocument();
        categoryCollection.insertOne(categoryDocument);
        return ((ObjectId) categoryDocument.get("_id"));
    }
    
}
