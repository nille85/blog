/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page.placeholder;

import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.web.page.Placeholder;
import be.nille.blog.web.page.TemplateModel;
import be.nille.blog.web.page.component.Component;
import be.nille.blog.web.page.component.HTMLComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 *
 * @author Niels Holvoet
 */
@org.springframework.stereotype.Component
@Scope(value="request", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class WidgetPlaceholder implements Component {
    
    private final CategoryService categoryService;
    
    @Autowired
    public WidgetPlaceholder(final CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    public String render() {
        Placeholder widgets =  new Placeholder()
                .addComponent(new HTMLComponent("templates/widgets/search.twig"))
                .addComponent(
                    new HTMLComponent("templates/widgets/categories.twig", 
                    new TemplateModel("categories",categoryService.findAll())
                )
        );
        return widgets.render();
    }
    
}
