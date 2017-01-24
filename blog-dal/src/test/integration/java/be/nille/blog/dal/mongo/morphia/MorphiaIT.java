/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo.morphia;

import be.nille.blog.dal.mongo.morphia.model.MgPost.Comment;
import be.nille.blog.dal.mongo.morphia.model.MgCategory;
import be.nille.blog.dal.mongo.morphia.model.MgUser;
import be.nille.blog.dal.mongo.morphia.model.MgPost;
import be.nille.blog.dal.mongo.morphia.model.MgPost.Content;
import be.nille.blog.dal.service.Category;
import be.nille.blog.dal.service.CategoryRepository;
import be.nille.blog.dal.service.mongo.CategoryMapper;
import be.nille.blog.dal.service.mongo.MgCategoryRepository;
import be.nille.blog.dal.service.mongo.MgRepository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class MorphiaIT {

    @Ignore
    public void test() {
        final String url = System.getenv("MONGO_URL");
        MongoClient client = new MongoClient(
                new MongoClientURI(url)
        );
        
        
        DatastoreFactory factory = new DatastoreFactory();
        Datastore datastore = factory.createDataStore(client, "openid-connect");
       
        
        /*
        MgUser user = new MgUser("johndoe@mail.be", "password");
        datastore.save(user);
                */
        
      
        
        CategoryRepository service = new MgCategoryRepository(datastore);
        Category category = service.add(new Category("Amazon WSD"));
        log.debug(category.toString());
        
        service.remove(category);
        
        
        
        
        /*
        for(int i=1;i<=10;i++){
            MgPost post = new MgPost(category, user, new Content("Blog post " + i, "Lead text "));
            datastore.save(post);
        }
        
        List<MgPost> posts = datastore.find(MgPost.class).asList();
        posts.stream().forEach((p) -> log.debug(p.toString()));
        
        MgPost post = posts.get(0);
        post.addComment(new Comment("author","some comment about the blog post"));
        datastore.save(post);
        
        posts = datastore.find(MgPost.class).asList();
        posts.stream().forEach((p) -> log.debug(p.toString()));
                */
       
        
    }

}
