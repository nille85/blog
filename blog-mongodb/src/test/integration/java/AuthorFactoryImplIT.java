

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.AuthorFactory;
import be.nille.blog.mongodb.AuthorFactoryImpl;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Niels Holvoet
 */
public class AuthorFactoryImplIT {
    
    private AuthorFactory factory;
    
    @Before
    public void setup(){
        final String url = System.getenv("MONGO_URL");
        MongoClient client = new MongoClient(
                new MongoClientURI(url)
        );
        
        MongoDatabase db = client.getDatabase("openid-connect");
        
        MongoCollection collection = db.getCollection("author");
        factory = new AuthorFactoryImpl(collection);
    }
    
    @Test
    public void authorShouldBeCreated(){
        factory.create("tester@test.be", new Author.Name("john", "doe"));
        
    }
    
}
