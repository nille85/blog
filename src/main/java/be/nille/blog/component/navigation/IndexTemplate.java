/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component.navigation;

import be.nille.blog.component.Template;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

/**
 *
 * @author Niels Holvoet
 */
public class IndexTemplate implements Template {
    
    private final JtwigTemplate template;
    private final Blog blog;
    
    public IndexTemplate(final String templateLocation, final Blog blog){
        this.template = JtwigTemplate.classpathTemplate(templateLocation);
        this.blog = blog; 
        
    }
    
    public IndexTemplate(final Blog blog){
        this("templates/index.twig", blog);
    }
    
    @Override
    public String render(){
        JtwigModel model = JtwigModel.newModel().with("blog", blog);
        return template.render(model);
    }
    
}
