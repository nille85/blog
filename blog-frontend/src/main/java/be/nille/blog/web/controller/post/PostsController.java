/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.controller.post;

import be.nille.blog.dal.MgPost;
import be.nille.blog.service.Category;


import be.nille.blog.service.CategoryService;
import be.nille.blog.service.PageInfo;
import be.nille.blog.service.Post;
import be.nille.blog.service.PostService;
import java.util.List;
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
public class PostsController {
    
    private final CategoryService categoryService;
    private final PostService postService;
    
    @Autowired
    public PostsController(final CategoryService categoryService, final PostService postService){
        this.categoryService = categoryService;
        this.postService = postService;
    }
    
    @RequestMapping("/")
    public String indexAction (ModelMap model) {
        
        PageInfo pageInfo = new PageInfo(postService.getNumberOfPosts());
        final HomePage homePage = new HomePage(categoryService,postService, pageInfo);
        model.put("page", homePage);
        return "blog/index";
    }

    @RequestMapping("/page/{pageId}")
    public String pageAction (ModelMap model,@PathVariable(name = "pageId") final int pageId) {
        PageInfo pageInfo = new PageInfo(pageId,10,postService.getNumberOfPosts());
        final HomePage homePage = new HomePage(categoryService,postService, pageInfo);
        model.put("page", homePage);
        return "blog/index";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}")
    public String postDetailAction (ModelMap model, @PathVariable(name = "postId") final String postId) {
        final PostDetailPage page = new PostDetailPage(categoryService, postService, postId);
        model.put("page", page);
        return "blog/post";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/posts/{postId}")
    public String postCommentAction (ModelMap model, @PathVariable(name = "postId") final String postId, @ModelAttribute AddCommentCommand addComment) {
        final PostDetailPage page = new PostDetailPage(categoryService, postService, postId);
        page.addComment(new MgPost.MgComment(addComment.getAuthor(), addComment.getComment()));
        model.put("page", page);
        return "blog/post";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/posts/search")
    public String searchPostsAction (ModelMap model, @RequestParam(required = true, name = "searchValue") final String searchValue) {
        log.info("searchValue:" + searchValue);
        final SearchPostsPage searchPage = new SearchPostsPage(categoryService,postService, searchValue);
        model.put("page", searchPage);
        return "blog/index";
    }
    
}
