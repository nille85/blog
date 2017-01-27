/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.boot;

import be.nille.blog.dal.Post;
import be.nille.blog.dal.Post.Comment;
import java.util.List;

import be.nille.blog.service.PostService;
import org.bson.types.ObjectId;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nholvoet
 */
@Controller
public class PostController {
    
    private final PostService postService;
    
    @Autowired
    public PostController(final PostService postService){
        this.postService = postService;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}")
    public String postDetailAction (ModelMap model, @PathVariable(name = "postId") final String postId) {
        Post post = postService.findPostById(postId);
        model.put("post", post);
        return "post";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/posts/{postId}")
    public String postCommentAction (ModelMap model, @PathVariable(name = "postId") final String postId, @ModelAttribute AddCommentCommand addComment) {

        Post post = postService.addCommentToPostWithId
                (new Comment(addComment.getAuthor(), addComment.getComment()), postId);
        model.put("post", post);
        return "post";
    }
    
}
