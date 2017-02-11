/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.controller.post;

import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.domain.post.Post;
import be.nille.blog.domain.post.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Niels Holvoet
 */
@Controller
public class CategoryController {
    
    private final CategoryService categoryService;
    private final PostService postService;
    
    @Autowired
    public CategoryController(final CategoryService categoryService, final PostService postService){
        this.categoryService = categoryService;
        this.postService = postService;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/categories/{categoryId}")
    public String searchPostsAction (ModelMap model, @PathVariable(name = "categoryId") final String categoryId) {
       
        List<Category> categories = categoryService.findAll();
        List<Post> posts = postService.findPostsByCategory(categoryId);
        
        model.put("page", new PostsPage(posts, categories));
        return "blog/index";
    }
    
}
