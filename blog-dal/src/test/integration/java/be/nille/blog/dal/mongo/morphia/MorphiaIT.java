/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo.morphia;


import be.nille.blog.dal.Author;
import be.nille.blog.dal.Author.Name;
import be.nille.blog.dal.Category;
import be.nille.blog.dal.Post;
import be.nille.blog.dal.Post.Content;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
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
        Datastore dataStore = factory.createDataStore(client, "openid-connect");
      
        Author author = new Author("johndoe@test.bl", new Name("john","doe"));
        dataStore.save(author);
        
        Category category = new Category("MongoDB");
        dataStore.save(category);
        
        for(int i=1;i<=20;i++){
            Post post = new Post(category, author, new Content("title " + i, "text " + i));
            dataStore.save(post);
        }
        
    
    }

}
