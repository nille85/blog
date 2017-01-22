/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component.home;

import be.nille.blog.component.Template;
import be.nille.blog.dal.Post;
import java.util.List;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

/**
 *
 * @author Niels Holvoet
 */
public class HomeTemplate implements Template {
    
    private final JtwigTemplate template;
    private final List<Post> posts;
    
    public HomeTemplate(final String templateLocation, final List<Post> posts){
        this.template = JtwigTemplate.classpathTemplate(templateLocation);
        this.posts = posts; 
        
    }
    
    public HomeTemplate(final List<Post> posts){
        this("templates/posts.twig", posts);
    }
    
    @Override
    public String render(){
        JtwigModel model = JtwigModel.newModel().with("posts", posts);
        return template.render(model);
    }
    
}
