/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.post;


import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.post.Comment;
import be.nille.blog.domain.post.Post;
import be.nille.blog.domain.post.PostService;
import be.nille.blog.mongo.MongoServiceException;
import be.nille.blog.mongo.category.CategoryDocument;
import be.nille.blog.mongo.category.MCategoryAccess;
import be.nille.blog.service.PageInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Niels Holvoet
 */
public class MongoPostService implements PostService {
    
    private final MongoDatabase database;
    private final MongoCollection collection;
    
    public MongoPostService(final MongoDatabase database){
        this.database = database;
        this.collection = database.getCollection("post");
    }

    @Override
    public List<Post> findAll() {
        FindIterable<Document> iterable = collection.find();
        List<Post> list = new ArrayList<>();
        iterable.iterator().forEachRemaining(d -> list.add(
                new Post(
                        new MPostAccess(d,database)
                )
        ));
        return list;
    }

    @Override
    public List<Post> findByPageInfo(PageInfo pageInfo) {
        FindIterable<Document> iterable = collection.find()
                .skip(pageInfo.getOffset())
                .limit(pageInfo.getLimit())
                .sort(new BasicDBObject("createdDate", -1));
        return getPostsByIterable(iterable);
                
    }

    @Override
    public List<Post> findPostsByCategory(String categoryId) {
        Bson filter = Filters.eq("category", categoryId);
        return getPostsByIterable(collection.find(filter));
      
    }

    @Override
    public List<Post> fullTextPostSearch(String searchValue) {
        return getPostsByIterable(collection.find(Filters.text(searchValue)));
    }
    
    private List<Post> getPostsByIterable(FindIterable<Document> iterable){
        List<Post> list = new ArrayList<>();
        iterable.iterator().forEachRemaining(d -> list.add(
                new Post(
                        new MPostAccess(d,database)
                )
        ));
        return list;
    }

    @Override
    public long getNumberOfPosts() {
        return collection.count();
    }

    @Override
    public Post findPostById(String postId) {
        FindIterable<Document> iterable = collection.find(Filters.eq("_id", new ObjectId(postId)));
        Document first = iterable.first();
        if(first != null){
            return new Post(new MPostAccess(first,database));
        }
       
        throw new MongoServiceException(String.format("Could not find post with id %s", postId));
    }

    @Override
    public Post save(Post post) {
        
        Document document =  new PostDocumentFactory().create(post);
        if(post.getId() == null){
             collection.insertOne(document);
        }else{
             Bson filter = Filters.eq("_id", new ObjectId(post.getId()));
             collection.updateOne(filter, document);
        }
        return new Post(new MPostAccess(document,database));
      
    }
    
}
