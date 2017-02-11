package be.nille.blog.web.controller.post;


import be.nille.blog.web.controller.BlogPage;

import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.domain.post.Post;
import be.nille.blog.domain.post.Comment;
import be.nille.blog.domain.post.PostService;
import be.nille.blog.mongo.MongoServiceException;




/**
 * Created by nholvoet on 27/01/2017.
 */
public final class PostDetailPage extends BlogPage {

    
    private final PostService postService;
    final String postId;
   

    public PostDetailPage(final CategoryService categoryService, final PostService postService, final String postId){
        super(categoryService);
        this.postService = postService;
        this.postId = postId;
    
    }

    public Post getPost(){
        try{
            return postService.findPostById(postId);                
        }catch(MongoServiceException ex){
             throw new RuntimeException(String.format("Post with id %s could not be found",postId), ex);
        }
    }
    
    public Post addComment(final Comment comment){
       
         Post post = getPost();
         post.addComment(comment);
         return postService.save(post);                
      
    }

}
