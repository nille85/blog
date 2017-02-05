/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.mongo.category.MongoCategoryService;
import be.nille.blog.domain.category.DCategory;
import be.nille.blog.service.Category;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;


import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class MongoCategoryServiceTest {
    
    private MongoCategoryService service;
    
    @Before
    public void setup(){
        final String url = System.getenv("MONGO_URL");
        MongoClient client = new MongoClient(
                new MongoClientURI(url)
        );
        MongoDatabase database = client.getDatabase("openid-connect");
        MongoCollection collection = database.getCollection("category");

        
        service = new MongoCategoryService(collection);
    }
    
    @Test
    public void testFetching(){
       
        List<? extends Category> categories = service.findAll();
        categories.stream().forEach(c -> log.debug(c.toString()));
    }
    
    @Test
    public void testSaving(){
        try{
            service.insert(new DCategory("Databases"));
        }catch(MongoException ex){
            log.error(ex.getMessage(), ex);
        }
        List<? extends Category> categories = service.findAll();
        categories.stream().forEach(c -> log.debug(c.toString()));
    }
    
}
