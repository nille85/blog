/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component.login;

import be.nille.blog.component.Template;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

/**
 *
 * @author Niels Holvoet
 */
public class LoginTemplate implements Template {
    
    private final JtwigTemplate template;
 
    
    public LoginTemplate(final String templateLocation){
        this.template = JtwigTemplate.classpathTemplate(templateLocation);
        
    }
    
    public LoginTemplate(){
        this("templates/login.twig");
    }
    
    @Override
    public String render(){
        JtwigModel model = JtwigModel.newModel();
        return template.render(model);
    }
    

    
}
