/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.controller.post;

import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.domain.post.Comment;
import be.nille.blog.domain.post.Post;
import be.nille.blog.domain.post.PostService;
import be.nille.blog.mongo.MongoServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}")
    public String postDetailAction (ModelMap model, @PathVariable(name = "postId") final String postId) {
     
        model.put("page", new PostDetailPage(getPost(postId),categoryService.findAll()));
        return "blog/post";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/posts/{postId}")
    public String postCommentAction (ModelMap model, @PathVariable(name = "postId") final String postId, @ModelAttribute AddCommentCommand addComment) {
        Post post = getPost(postId);
        log.debug(post.toString());
        post.addComment(new Comment(addComment.getAuthor(), addComment.getComment()));
        Post updated = postService.save(post);
        log.debug(updated.toString());
        model.put("page", new PostDetailPage(updated, categoryService.findAll()));
        return "blog/post";
    }
    
    private Post getPost(final String postId){
        try{
            return postService.findPostById(postId);                
        }catch(MongoServiceException ex){
             throw new RuntimeException(String.format("Post with id %s could not be found",postId), ex);
        }
    }
    
}
