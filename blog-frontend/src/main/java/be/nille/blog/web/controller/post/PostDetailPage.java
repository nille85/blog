package be.nille.blog.web.controller.post;


import be.nille.blog.web.controller.BlogPage;

import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.domain.post.Post;
import be.nille.blog.domain.post.Comment;
import be.nille.blog.domain.post.PostService;




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
        Post post = postService.findPostById(postId)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Post with id %s could not be found",postId))
        );
        return post;
    }
    
    public Post addComment(final Comment comment){
        Post post = postService.addCommentToPostWithId(comment, postId);
        return post;
    }

}
