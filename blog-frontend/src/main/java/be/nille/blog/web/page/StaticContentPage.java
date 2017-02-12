/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page;

import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.web.page.component.Component;
import be.nille.blog.web.page.component.HTMLComponent;
import be.nille.blog.web.page.component.StringComponent;
import be.nille.blog.web.page.placeholder.WidgetPlaceholder;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 *
 * @author Niels Holvoet
 */
@org.springframework.stereotype.Component
@Scope(value="request", proxyMode= ScopedProxyMode.TARGET_CLASS)
@Slf4j
public class StaticContentPage implements Component {
     
    private final WidgetPlaceholder placeholder;
    
    @Autowired
    public StaticContentPage(final WidgetPlaceholder placeholder){
        this.placeholder = placeholder;
    }

    @Override
    public String render() {
        log.debug("rendering static content page");
        Placeholder left = new Placeholder()
                .addComponent(new StringComponent("this is some content"));
        
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/widgets/page.twig");
        JtwigModel twigModel = JtwigModel.newModel().with("rightColumn", placeholder.render())
                .with("leftColumn", left.render());
     
        String html = template.render(twigModel);
        return html;
      
   
        
    }
    
}
