/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import lombok.extern.slf4j.Slf4j;

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
