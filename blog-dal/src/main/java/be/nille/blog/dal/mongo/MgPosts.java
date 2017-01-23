/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo;


import be.nille.blog.dal.DPost;
import be.nille.blog.dal.Post;
import com.mongodb.client.MongoCollection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;


/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class MgPosts extends MongoRepository<Post>{
    
    
    public MgPosts(final MongoCollection collection){
        super(collection);
    }

  
    @Override
    public Post fromDocument(Document document) {
        return new MgPost(
                    document.getObjectId("_id").toHexString(),
                    new DPost(
                            document.getString("title"),
                            document.getString("lead"),
                            document.get("comments", List.class))
                );      
    }
    
    @Override
    public Document fromEntity(final Post post) {
        Document document = new Document();
       
        return document.append("title", post.getTitle())
                .append("lead", post.getLead())
                .append("comments", post.getComments());
    }

    
       
}
