/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web;

import be.nille.blog.dal.mongo.morphia.DatastoreFactory;
import be.nille.blog.service.CategoryService;
import be.nille.blog.service.PostService;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Niels Holvoet
 */
@Configuration
public class BeanConfig {

    @Bean
    public Datastore dataStore() {
        final String url = System.getenv("MONGO_URL");
        try {
            MongoClient client = new MongoClient(
                    new MongoClientURI(url)
            );
            DatastoreFactory factory = new DatastoreFactory();
            Datastore dataStore = factory.createDataStore(client, "openid-connect");
            return dataStore;
        } catch (RuntimeException ex) {
            throw new RuntimeException("Could not connect to Mongo Database", ex);
        }

    }
    
    
    @Bean
    public CategoryService categoryService(){
     return new CategoryService(dataStore());
    }
    
    @Bean
    public PostService postService(){
     return new PostService(dataStore());
    }

}
