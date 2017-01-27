/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.boot;

import be.nille.blog.dal.Post;
import java.util.List;

import be.nille.blog.page.HomePage;
import be.nille.blog.page.PageInfo;
import be.nille.blog.service.CategoryService;
import be.nille.blog.service.PostService;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nholvoet
 */
@Controller
public class HomeController {
    
    private final CategoryService categoryService;
    private final PostService postService;
    
    @Autowired
    public HomeController(final CategoryService categoryService, final PostService postService){
        this.categoryService = categoryService;
        this.postService = postService;
    }
    
    @RequestMapping("/")
    public String indexAction (ModelMap model) {
        PageInfo pageInfo = new PageInfo(postService.getNumberOfPosts());
        final HomePage homePage = new HomePage(categoryService,postService, pageInfo);
        model.put("page", homePage);
        return "index";
    }

    @RequestMapping("/page/{pageId}")
    public String pageAction (ModelMap model,@PathVariable(name = "pageId") final int pageId) {
        PageInfo pageInfo = new PageInfo(pageId,10,postService.getNumberOfPosts());
        final HomePage homePage = new HomePage(categoryService,postService, pageInfo);
        model.put("page", homePage);
        return "index";
    }
    
}
