package be.nille.blog.service;

import be.nille.blog.dal.Post;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nholvoet on 27/01/2017.
 */
@Service
public class PostService {

    private final Datastore dataStore;

    @Autowired
    public PostService(final Datastore dataStore){
        this.dataStore = dataStore;
    }


    public List<Post> findAll(){
        List<Post> posts = dataStore.createQuery(Post.class).order("-createdDate").asList();
        return posts;
    }

    public List<Post> findByOffsetAndLimit(final int offset, final int limit){
        List<Post> posts = dataStore.createQuery(Post.class)
                .offset(offset)
                .limit(limit)
                .order("-createdDate").asList();
        return posts;
    }

    public List<Post> findPostsByCategory(final String categoryId){
        return dataStore.createQuery(Post.class)
                .filter("category.$id",new ObjectId(categoryId))
                .asList();
    }

    public long getNumberOfPosts(){
        return dataStore.createQuery(Post.class).countAll();
    }
 }
