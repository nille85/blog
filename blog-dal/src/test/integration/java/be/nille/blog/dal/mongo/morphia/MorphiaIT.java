/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo.morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class MorphiaIT {

    @Test
    public void test() {
        final String url = System.getenv("MONGO_URL");
        MongoClient client = new MongoClient(
                new MongoClientURI(url)
        );
        DatastoreFactory factory = new DatastoreFactory();
        Datastore datastore = factory.createDataStore(client, "openid-connect");
        
        
        for(int i=1;i<=10;i++){
            Post post = new Post("Blog post " + i, "Lead text " + i);
            datastore.save(post);
        }
        
        List<Post> posts = datastore.find(Post.class).asList();
        posts.stream().forEach((p) -> log.debug(p.toString()));
        
        Post post = posts.get(0);
        post.addComment(new Comment("author","some comment about the blog post"));
        datastore.save(post);
        
        posts = datastore.find(Post.class).asList();
        posts.stream().forEach((p) -> log.debug(p.toString()));
       
        
    }

}
