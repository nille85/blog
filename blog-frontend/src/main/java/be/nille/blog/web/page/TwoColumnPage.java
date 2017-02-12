/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page;

import be.nille.blog.web.page.component.Component;
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
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/page/page.twig");
        JtwigModel twigModel = JtwigModel.newModel().with("right", right.render())
                .with("left", left.render());
        String html = template.render(twigModel);
        return html;
    }
}
