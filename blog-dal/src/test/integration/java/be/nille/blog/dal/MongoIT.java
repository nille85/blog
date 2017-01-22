/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

import be.nille.blog.dal.mongo.MgPosts;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class MongoIT {
    
    @Test
    public void testConnection(){
        final String url = System.getenv("MONGO_URL");

        try (MongoClient mongoClient = new MongoClient(
                new MongoClientURI(url)
        )) {
           mongoClient.getDatabase("openid-connect");    
        }
    }
    
}
