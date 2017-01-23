/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component.post;

import be.nille.blog.component.Page;
import be.nille.blog.component.Template;
import be.nille.blog.dal.Post;
import be.nille.blog.dal.mongo.MgPosts;
import be.nille.blog.dal.mongo.MongoRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import spark.Request;
import spark.Response;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class PostPage implements Page {

    private final MongoDatabase database;
    
    public PostPage(MongoDatabase database) {
        this.database = database;
    }

    @Override
    public String handleRequest(Request request, Response response) {
        String postId = request.params(":id");
        MongoCollection<Document> collection = database.getCollection("posts");
        MongoRepository<Post> posts = new MgPosts(collection);
        
        Optional<Post> optional = posts.findOne(postId);
        Post post = optional.orElseThrow(() -> new RuntimeException(
                String.format("the id %s could not be found", postId)
        ));
      
        Template template = new PostTemplate(post);
        return template.render();
    }

}
