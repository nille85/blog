package be.nille.blog.service;

import be.nille.blog.dal.Post;
import be.nille.blog.web.page.PageInfo;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import java.util.List;

/**
 * Created by nholvoet on 27/01/2017.
 */
public class PostService {

    private final Datastore dataStore;

   
    public PostService(final Datastore dataStore){
        this.dataStore = dataStore;
    }


    public List<Post> findAll(){
        List<Post> posts = dataStore.createQuery(Post.class).order("-createdDate").asList();
        return posts;
    }

    public List<Post> findByOffsetAndLimit(final PageInfo pageInfo){

        final int pageNumberForMongo = pageInfo.getPageNumber() -1;
        final int numberOfPostsInPage = pageInfo.getNumberOfItemsInPage();
        final int offset = pageNumberForMongo * numberOfPostsInPage;
        final int limit = offset + numberOfPostsInPage;


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

    public Post findPostById(final String postId){
        Post post = dataStore.get(Post.class, new ObjectId(postId));
        return post;
    }

    public long getNumberOfPosts(){
        return dataStore.createQuery(Post.class).countAll();
    }

    public Post addCommentToPostWithId(Post.Comment comment, final String postId){
        Post post = dataStore.get(Post.class, new ObjectId(postId));
        post.addComment(comment);
        dataStore.save(post);
        post = dataStore.get(Post.class, new ObjectId(postId));
        return post;
    }
 }
