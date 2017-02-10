/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web;

import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.domain.post.PostService;
import be.nille.blog.mongo.category.MongoCategoryService;
import be.nille.blog.mongo.post.MongoPostService;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Niels Holvoet
 */
@Configuration
@Slf4j
public class BeanConfig {

    @Bean
    public MongoDatabase database() {
        final String url = System.getenv("MONGO_URL");
        log.debug("MONGO URL:" + url);
        try {
            MongoClient client = new MongoClient(
                    new MongoClientURI(url)
            );
            return client.getDatabase("openid-connect");
        } catch (RuntimeException ex) {
            log.error(ex.getMessage());
            throw new RuntimeException(
                    String.format("Could not connect to Mongo Database with URL %s", url));
        }

    }
    
    @Bean
    public CategoryService categoryService(){
     return new MongoCategoryService(database());
    }
    
    @Bean
    public PostService postService(){
     return new MongoPostService(database());
    }

}
