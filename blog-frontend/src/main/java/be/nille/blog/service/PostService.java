package be.nille.blog.service;

import be.nille.blog.dal.MgPost;
import be.nille.blog.web.page.PageInfo;
import com.mongodb.client.model.Sorts;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import java.util.List;
import java.util.Optional;
import static org.mongodb.morphia.aggregation.Group.grouping;
import static org.mongodb.morphia.aggregation.Group.push;
import org.mongodb.morphia.aggregation.Sort;

/**
 * Created by nholvoet on 27/01/2017.
 */
public class PostService {

    private final Datastore dataStore;

   
    public PostService(final Datastore dataStore){
        this.dataStore = dataStore;
    }


    public List<MgPost> findAll(){
        List<MgPost> posts = dataStore.createQuery(MgPost.class)
                .order("-createdDate").asList();
        return posts;
    }

    public List<MgPost> findByOffsetAndLimit(final PageInfo pageInfo){

        final int pageNumberForMongo = pageInfo.getPageNumber() -1;
        final int numberOfPostsInPage = pageInfo.getNumberOfItemsInPage();
        final int offset = pageNumberForMongo * numberOfPostsInPage;
        final int limit = offset + numberOfPostsInPage;


        List<MgPost> posts = dataStore.createQuery(MgPost.class)
                .offset(offset)
                .limit(limit)
                .order("-createdDate").asList();
        return posts;
    }

    public List<MgPost> findPostsByCategory(final String categoryId){
        return dataStore.createQuery(MgPost.class)
                .filter("category.$id",new ObjectId(categoryId))
                .asList();
    }

    public Optional<MgPost> findPostById(final String postId){
        
        List<MgPost> posts = dataStore.createQuery(MgPost.class)
                .filter("id", new ObjectId(postId))
                .asList();
        if(!posts.isEmpty()){
            return Optional.of(posts.get(0));
        }
           
        return Optional.empty();
    }

    public long getNumberOfPosts(){
        return dataStore.createQuery(MgPost.class).countAll();
    }

    public MgPost addCommentToPostWithId(MgPost.Comment comment, final String postId){
        
        
        MgPost post = dataStore.get(MgPost.class, new ObjectId(postId));
        
        
        
        post.addComment(comment);
        dataStore.save(post);
        post = dataStore.get(MgPost.class, new ObjectId(postId));
        return post;
    }
 }
