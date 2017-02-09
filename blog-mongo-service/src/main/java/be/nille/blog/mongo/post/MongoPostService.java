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
import be.nille.blog.mongo.category.CategoryFactory;
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
    public List<? extends Post> findAll() {
        FindIterable<Document> iterable = collection.find();
        List<Post> list = new ArrayList<>();
        PostFactory factory = new PostFactory(database);
        iterable.iterator().forEachRemaining(d -> list.add(factory.create(d)));
        return list;
    }

    @Override
    public List<? extends Post> findByPageInfo(PageInfo pageInfo) {
        FindIterable<Document> iterable = collection.find()
                .skip(pageInfo.getOffset())
                .limit(pageInfo.getLimit())
                .sort(new BasicDBObject("createdDate", -1));
        List<Post> list = new ArrayList<>();
        PostFactory factory = new PostFactory(database);
        iterable.iterator().forEachRemaining(d -> list.add(factory.create(d)));
        return list;
                
    }

    @Override
    public List<? extends Post> findPostsByCategory(String categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends Post> fullTextPostSearch(String searchValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getNumberOfPosts() {
        return collection.count();
    }

    @Override
    public Optional<? extends Post> findPostById(String postId) {
        FindIterable<Document> iterable = collection.find(Filters.eq("id", new ObjectId(postId)));
        Document first = iterable.first();
        if(first != null){
            return Optional.of(new PostFactory(database).create(first));
        }
       
        return Optional.empty();
    }

    @Override
    public Post addCommentToPostWithId(Comment comment, String postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
