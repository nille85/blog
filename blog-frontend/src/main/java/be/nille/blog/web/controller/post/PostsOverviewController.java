/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.controller.post;

import be.nille.blog.domain.post.Comment;


import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.service.PageInfo;
import be.nille.blog.domain.post.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nholvoet
 */
@Controller
@Slf4j
public class PostsOverviewController {
    
    private final CategoryService categoryService;
    private final PostService postService;
    
    @Autowired
    public PostsOverviewController(final CategoryService categoryService, final PostService postService){
        this.categoryService = categoryService;
        this.postService = postService;
    }
    
    @RequestMapping("/")
    public String indexAction (ModelMap model) {
        PageInfo pageInfo = new PageInfo(postService.getNumberOfPosts());
        model.put("page", new PostsPage(postService.findByPageInfo(pageInfo), categoryService.findAll()));
        return "blog/index";
    }

    @RequestMapping("/page/{pageId}")
    public String pageAction (ModelMap model,@PathVariable(name = "pageId") final int pageId) {
        PageInfo pageInfo = new PageInfo(pageId,10,postService.getNumberOfPosts());
        model.put("page", new PostsPage(postService.findByPageInfo(pageInfo), categoryService.findAll()));
        return "blog/index";
    }
    
    
    
    
    
}
