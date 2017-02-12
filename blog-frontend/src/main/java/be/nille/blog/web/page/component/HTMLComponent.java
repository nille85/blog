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
public class HTMLComponent implements Component {
    
    private final String templateLocation;
    private final TemplateModel model;
    
    public HTMLComponent(final String templateLocation){
        this(templateLocation, null);
    }
    
    public HTMLComponent(final String templateLocation, final TemplateModel model){
        this.templateLocation = templateLocation;
        this.model = model;
    }
    
    
    @Override
    public String render(){
        JtwigTemplate template = JtwigTemplate.classpathTemplate(templateLocation);
        JtwigModel twigModel = null;
        if(model != null){
            twigModel = JtwigModel.newModel().with(model.getName(), model.getValue());
        }
        String html = template.render(twigModel);
        return html;
    }
    
}
