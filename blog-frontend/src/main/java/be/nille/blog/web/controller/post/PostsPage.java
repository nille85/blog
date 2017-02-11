/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.controller.post;

import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.post.Post;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class PostsPage {
    
    private final List<Category> categories;
    private final List<Post> posts;
    
    public PostsPage(final List<Post> posts, final List<Category> categories){
        this.categories = categories;
        this.posts = posts;
    }
    
}
