/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page.placeholder;

import be.nille.blog.domain.post.Post;
import be.nille.blog.web.page.template.TemplateModel;
import be.nille.blog.web.page.component.Component;
import be.nille.blog.web.page.component.CompositeComponent;
import be.nille.blog.web.page.component.TwigComponent;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class PostsPlaceholder implements Component{
    
    private final List<Post> posts;
    
    public PostsPlaceholder(final List<Post> posts){
        this.posts = posts;
    }
    
    @Override
    public String render() {
        CompositeComponent placeholder =  new CompositeComponent()             
                .addComponent(new TwigComponent("templates/placeholder/posts_left.twig", 
                    new TemplateModel("posts", posts)
                )
        );
        return placeholder.render();
    }
    
}
