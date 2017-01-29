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
import java.util.Iterator;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.Ignore;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import static org.mongodb.morphia.aggregation.Group.grouping;
import static org.mongodb.morphia.aggregation.Group.push;
import org.mongodb.morphia.aggregation.Sort;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class MorphiaIT {
    
    
    @Test
    public void testAggregation(){
        final String url = System.getenv("MONGO_URL");
        MongoClient client = new MongoClient(
                new MongoClientURI(url)
        );
        
        
        DatastoreFactory factory = new DatastoreFactory();
        Datastore dataStore = factory.createDataStore(client, "openid-connect");
        
        Query query = dataStore.createQuery(Post.class)
                .filter("$id", new ObjectId("588a4b37a3f9dc540c6ed3c8"));
        
        Iterator<Post> posts = dataStore.createAggregation(Post.class)
                .unwind("comments")
                .match(query)
                .sort(Sort.descending("comments.createdDate"))
                //.group("id", grouping("comments", push("comments")))
                
                .aggregate(Post.class);
        
        posts.forEachRemaining(p -> log.debug(p.toString()));
        
    }
    

    @Ignore
    public void test() {
        final String url = System.getenv("MONGO_URL");
        MongoClient client = new MongoClient(
                new MongoClientURI(url)
        );
        
        
        DatastoreFactory factory = new DatastoreFactory();
        Datastore dataStore = factory.createDataStore(client, "openid-connect");
      
        Author author = new Author("johndoe@test.bl", "password", new Name("john","doe"));
        dataStore.save(author);
        
        Category category = new Category("MongoDB");
        dataStore.save(category);
        
        for(int i=1;i<=20;i++){
            Post post = new Post(category, author, new Content("title " + i, "text " + i));
            dataStore.save(post);
        }
        
    
    }

}
