/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.post;

import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.post.Post;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

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
        ObjectId objectId = document.getObjectId("_id");
        
        //reconstitute category
        
        
        
        //reconstitute author
        MongoCollection authorCollection = database.getCollection("author");
        ObjectId authorObjectId = (ObjectId) document.get("author");
        authorCollection.find(Filters.eq("_id", authorObjectId));
      
        return new MPost(objectId.toHexString(), null);
    }
    
    
    private Category reconstituteCategory(final Document document){
        //Category category = Category.class.newInstance();
        MongoCollection categoryCollection = database.getCollection("category");
        ObjectId categoryObjectId = (ObjectId) document.get("category");
        FindIterable<Document> iterable = categoryCollection.find(Filters.eq("_id", categoryObjectId));
        Document first = iterable.first();
        if(first != null){
           
        }
        return null;
        
    }
}
