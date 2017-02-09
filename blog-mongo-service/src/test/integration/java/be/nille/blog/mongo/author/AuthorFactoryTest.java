/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.author;

import be.nille.blog.domain.author.Author;
import be.nille.blog.mongo.category.*;
import be.nille.blog.mongo.category.MongoCategoryService;
import be.nille.blog.domain.category.DCategory;
import be.nille.blog.domain.category.Category;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.junit.Before;


import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class AuthorFactoryTest {
    
    private  MongoCollection collection;
    
    @Before
    public void setup(){
        final String url = System.getenv("MONGO_URL");
        MongoClient client = new MongoClient(
                new MongoClientURI(url)
        );
        MongoDatabase database = client.getDatabase("openid-connect");
        collection = database.getCollection("author");

        
        
    }
    
    @Test
    public void testFetching(){
        FindIterable<Document> iterable = collection.find();
        List<Author> list = new ArrayList<>();
        AuthorFactory factory = new AuthorFactory();
        iterable.iterator().forEachRemaining(d -> list.add(factory.create(d)));
        
        list.forEach(a -> log.debug(a.toString()));
    }
    
   
    
}
