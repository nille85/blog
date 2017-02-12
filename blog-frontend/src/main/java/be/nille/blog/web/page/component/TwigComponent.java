/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page.component;

import be.nille.blog.web.page.template.TemplateModel;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

/**
 *
 * @author Niels Holvoet
 */
public class TwigComponent implements Component {
    
    private final String templateLocation;
    private final TemplateModel[] models;
    
  
    
    public TwigComponent(final String templateLocation, final TemplateModel ... models){
        this.templateLocation = templateLocation;
        this.models = models;
    }
    
    
    @Override
    public String render(){
        JtwigTemplate template = JtwigTemplate.classpathTemplate(templateLocation);
        JtwigModel twigModel = null;
        if(models != null){
            twigModel = JtwigModel.newModel();
            for(TemplateModel model : models){
                twigModel.with(model.getName(), model.getValue());
            }     
        }
        String html = template.render(twigModel);
        return html;
    }
    
}
