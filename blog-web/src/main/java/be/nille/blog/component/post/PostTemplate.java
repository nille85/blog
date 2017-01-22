/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component.post;

import be.nille.blog.component.Template;
import be.nille.blog.dal.Post;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

/**
 *
 * @author Niels Holvoet
 */
public class PostTemplate implements Template {
    
    private final JtwigTemplate template;
    private final Post post;
    
    public PostTemplate(final String templateLocation, final Post post){
        this.template = JtwigTemplate.classpathTemplate(templateLocation);
        this.post = post; 
        
    }
    
    public PostTemplate(final Post post){
        this("templates/post.twig", post);
    }
    
    @Override
    public String render(){
        JtwigModel model = JtwigModel.newModel().with("post", post);
        return template.render(model);
    }
    
}
