/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo;


import be.nille.blog.dal.Comment;
import be.nille.blog.dal.DPost;
import be.nille.blog.dal.Post;
import be.nille.blog.dal.Posts;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class MgPosts implements Posts{
    
    private final MongoCollection collection;
    
    public MgPosts(final MongoCollection collection){
        this.collection = collection;
    }

    @Override
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
         FindIterable iterable = collection.find();
         try (MongoCursor<Document> cursor = iterable.iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Post post = fromDocument(document);
                posts.add(post);
            }
        }
         return posts;
    }
    
    @Override
    public Optional<Post> findOne(String id) {
        Bson bson = eq("_id", new ObjectId(id));
        FindIterable<Document> iterable = collection.find(bson);
   
        Document document = iterable.first();
        if(document != null){
            return Optional.of(fromDocument(document));
        }
        return Optional.empty();
    }
    
    @Override
    public void add(final Post post) {
        collection.insertOne(fromPost(post));
    }
    
    @Override
    public void update(final Post post){
        Bson bson = eq("_id", post.getId());
        collection.updateOne(bson, fromPost(post));
    }
    
    @Override
    public void remove(final Post post){
        Bson bson = eq("_id", post.getId());
        collection.deleteOne(bson);
    }

    private Post fromDocument(Document document) {
        return new MgPost(
                    document.getObjectId("_id").toHexString(),
                    new DPost(
                            document.getString("title"),
                            document.getString("lead"),
                            document.get("comments", List.class))
                );      
    }
    
    public Document fromPost(final Post post) {
        Document document = new Document();
       
        return document.append("title", post.getTitle())
                .append("lead", post.getLead())
                .append("comments", post.getComments());
    }

    
       
}
