/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page;

import be.nille.blog.web.page.component.Component;
import be.nille.blog.web.page.component.TwigComponent;
import be.nille.blog.web.page.template.TemplateModel;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

/**
 *
 * @author Niels Holvoet
 */
public class TwoColumnPage implements Component {
    
    private final Component left;
    private final Component right;
    
    public TwoColumnPage(final Component left, final Component right){
        this.left = left;
        this.right = right;
    }   

    @Override
    public String render() {
        final TemplateModel[] models = new TemplateModel[]{
            new TemplateModel("right", right.render()),
            new TemplateModel("left", left.render())
        };
        return new TwigComponent("templates/page/page.twig", models).render(); 
    }
}
