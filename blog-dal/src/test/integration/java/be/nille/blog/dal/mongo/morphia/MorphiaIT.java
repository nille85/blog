/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo.morphia;


import be.nille.blog.dal.MgAuthor;
import be.nille.blog.dal.MgCategory;
import be.nille.blog.dal.MgPost;

import be.nille.blog.domain.author.Name;
import be.nille.blog.domain.post.Content;
import be.nille.blog.domain.post.Post;
import be.nille.blog.domain.post.PostService;
import be.nille.blog.service.mongo.MgPostService;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.util.Iterator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.Ignore;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.aggregation.Sort;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class MorphiaIT {
    
    
    @Test
    public void testFullSearch(){
        final String url = System.getenv("MONGO_URL");
        MongoClient client = new MongoClient(
                new MongoClientURI(url)
        );
        
        
        DatastoreFactory factory = new DatastoreFactory();
        Datastore dataStore = factory.createDataStore(client, "openid-connect");
        
        final PostService postService = new MgPostService(dataStore);
        
        
        List<? extends Post> posts = postService.fullTextPostSearch("2");
        log.debug("Number of posts:" + posts.size());
    }
    
    
    @Ignore
    public void testAggregation(){
        final String url = System.getenv("MONGO_URL");
        MongoClient client = new MongoClient(
                new MongoClientURI(url)
        );
        
        
        DatastoreFactory factory = new DatastoreFactory();
        Datastore dataStore = factory.createDataStore(client, "openid-connect");
        
        Query query = dataStore.createQuery(MgPost.class)
                .filter("$id", new ObjectId("588a4b37a3f9dc540c6ed3c8"));
        
        Iterator<MgPost> posts = dataStore.createAggregation(MgPost.class)
                .unwind("comments")
                .match(query)
                .sort(Sort.descending("comments.createdDate"))
                //.group("id", grouping("comments", push("comments")))
                
                .aggregate(MgPost.class);
        
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
      
       
        
        MgAuthor author = new MgAuthor("johndoe@test.bl", "password", new Name("john","doe"));
        dataStore.save(author);
        
        MgCategory category = new MgCategory("MongoDB");
        dataStore.save(category);
        
        for(int i=1;i<=20;i++){
            MgPost post = new MgPost(category, author, new Content("title " + i, "text " + i));
            dataStore.save(post);
        }
        
    
    }

}
