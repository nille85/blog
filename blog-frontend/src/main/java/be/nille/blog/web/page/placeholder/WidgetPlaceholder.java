/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page.placeholder;

import be.nille.blog.domain.category.Category;
import be.nille.blog.web.page.component.CompositeComponent;
import be.nille.blog.web.page.template.TemplateModel;
import be.nille.blog.web.page.component.Component;
import be.nille.blog.web.page.component.TwigComponent;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class WidgetPlaceholder implements Component {
    
    private final List<Category> categories;
    
    public WidgetPlaceholder(final List<Category> categories){
        this.categories = categories;
    }

    @Override
    public String render() {
        CompositeComponent widgets =  new CompositeComponent()
                .addComponent(new TwigComponent("templates/widgets/search.twig"))
                .addComponent(new TwigComponent("templates/widgets/categories.twig", 
                    new TemplateModel("categories",categories)
                )
        );
        return widgets.render();
    }
    
}
