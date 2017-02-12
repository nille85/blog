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
import be.nille.blog.web.page.TwoColumnPage;
import be.nille.blog.web.page.placeholder.PostsPlaceholder;
import be.nille.blog.web.page.placeholder.WidgetPlaceholder;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
@Controller
public class SearchController {
    
    private final CategoryService categoryService;
    private final PostService postService;
    
    @Autowired
    public SearchController(final CategoryService categoryService, final PostService postService){
        this.categoryService = categoryService;
        this.postService = postService;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/posts/search", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchPostsAction (ModelMap model, @RequestParam(required = true, name = "searchValue") final String searchValue) {
        log.info("searchValue:" + searchValue);
        List<Category> categories = categoryService.findAll();
        List<Post> posts = postService.fullTextPostSearch(searchValue);
        return new TwoColumnPage(
                new PostsPlaceholder(posts), 
                new WidgetPlaceholder(categories)
        ).render();
    
    }
}
