package be.nille.blog.web.controller.post;

import be.nille.blog.dal.Category;
import be.nille.blog.dal.Post;
import be.nille.blog.dal.Post.Comment;
import be.nille.blog.service.CategoryService;
import be.nille.blog.service.PostService;

import java.util.List;


/**
 * Created by nholvoet on 27/01/2017.
 */
public final class PostDetailPage {

    private final CategoryService categoryService;
    private final PostService postService;
    final String postId;
   

    public PostDetailPage(final CategoryService categoryService, final PostService postService, final String postId){
        this.categoryService = categoryService;
        this.postService = postService;
        this.postId = postId;
       
    }

    public Post getPost(){
        Post post = postService.findPostById(postId);
        return post;
    }

    public List<Category> getCategories(){
        return categoryService.findAll();
    }
    
    public Post addComment(final Comment comment){
        Post post = postService.addCommentToPostWithId(comment, postId);
        return post;
    }

}
