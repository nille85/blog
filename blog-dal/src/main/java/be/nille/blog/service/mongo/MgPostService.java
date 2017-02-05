package be.nille.blog.service.mongo;

import be.nille.blog.service.PageInfo;
import be.nille.blog.dal.MgPost;
import be.nille.blog.service.Post;
import be.nille.blog.service.Post.Comment;

import be.nille.blog.service.PostService;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import java.util.List;
import java.util.Optional;

/**
 * Created by nholvoet on 27/01/2017.
 */
public class MgPostService implements PostService {

    private final Datastore dataStore;

   
    public MgPostService(final Datastore dataStore){
        this.dataStore = dataStore;
    }


    @Override
    public List<MgPost> findAll(){
        List<MgPost> posts = dataStore.createQuery(MgPost.class)
                .order("-createdDate").asList();
        return posts;
    }

    @Override
    public List<MgPost> findByPageInfo(final PageInfo pageInfo){
        List<MgPost> posts = dataStore.createQuery(MgPost.class)
                .offset(pageInfo.getOffset())
                .limit(pageInfo.getLimit())
                .order("-createdDate").asList();
        return posts;
    }

    @Override
    public List<MgPost> findPostsByCategory(final String categoryId){
        return dataStore.createQuery(MgPost.class)
                .filter("category.$id",new ObjectId(categoryId))
                .asList();
    }

    @Override
    public Optional<MgPost> findPostById(final String postId){
        
        List<MgPost> posts = dataStore.createQuery(MgPost.class)
                .filter("id", new ObjectId(postId))
                .asList();
        if(!posts.isEmpty()){
            return Optional.of(posts.get(0));
        }
           
        return Optional.empty();
    }

    @Override
    public long getNumberOfPosts(){
        return dataStore.createQuery(MgPost.class).countAll();
    }


    @Override
    public Post addCommentToPostWithId(Comment comment, String postId) {
        MgPost post = dataStore.get(MgPost.class, new ObjectId(postId));
           
        
        post.addComment(comment);
        dataStore.save(post);
        post = dataStore.get(MgPost.class, new ObjectId(postId));
        return post;
    }
    
    
    @Override
    public List<MgPost> fullTextPostSearch(final String searchValue){
         List<MgPost> posts = dataStore.createQuery(MgPost.class)
                .search(searchValue)
                 .asList();
             
         return posts;
    }

    
 }
