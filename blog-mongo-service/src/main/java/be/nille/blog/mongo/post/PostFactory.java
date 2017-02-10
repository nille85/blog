/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.post;

import be.nille.blog.domain.post.DPost;
import be.nille.blog.domain.post.Post;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
public class PostFactory {
    
    private final MongoDatabase database;
    
    public PostFactory(final MongoDatabase database){
        this.database = database;
    }
    
  
    public Post create(final Document document) {
        return new DPost(new MPost(document,database));
    }
   
}
