/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.controller.post;

import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.domain.post.Comment;
import be.nille.blog.domain.post.Post;
import be.nille.blog.domain.post.PostService;
import be.nille.blog.mongo.MongoServiceException;
import be.nille.blog.web.page.TwoColumnPage;
import be.nille.blog.web.page.placeholder.PostDetailPlaceholder;
import be.nille.blog.web.page.placeholder.PostsPlaceholder;
import be.nille.blog.web.page.placeholder.WidgetPlaceholder;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
@Controller
public class PostDetailController {
    
    private final CategoryService categoryService;
    private final PostService postService;
    
    @Autowired
    public PostDetailController(final CategoryService categoryService, final PostService postService){
        this.categoryService = categoryService;
        this.postService = postService;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String postDetailAction (@PathVariable(name = "postId") final String postId) {
        return renderPage(getPost(postId), categoryService.findAll());
       
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/posts/{postId}", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String postCommentAction (@PathVariable(name = "postId") final String postId, @ModelAttribute AddCommentCommand addComment) {
        Post post = getPost(postId);
        log.debug(post.toString());
        post.addComment(new Comment(addComment.getAuthor(), addComment.getComment()));
        Post updated = postService.save(post);
        return renderPage(updated, categoryService.findAll());
    }
    
    private String renderPage(final Post post, final List<Category> categories){
            return new TwoColumnPage(
                new PostDetailPlaceholder(post), 
                new WidgetPlaceholder(categories)
        ).render();
       
    }
    
    private Post getPost(final String postId){
        try{
            Post post = postService.findPostById(postId);
            return post;
       
        }catch(MongoServiceException ex){
             throw new RuntimeException(String.format("Post with id %s could not be found",postId), ex);
        }
    }
    
}
