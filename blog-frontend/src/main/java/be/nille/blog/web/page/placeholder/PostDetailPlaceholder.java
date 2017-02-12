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
import be.nille.blog.web.page.component.HTMLComponent;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class PostDetailPlaceholder implements Component{
    
    private final Post post;
    
    public PostDetailPlaceholder(final Post post){
        this.post = post;
    }
    
    @Override
    public String render() {
        CompositeComponent placeholder =  new CompositeComponent()             
                .addComponent(
                    new HTMLComponent("templates/placeholder/post_detail.twig", 
                    new TemplateModel("post", post)
                )
        );
        return placeholder.render();
    }
    
}
