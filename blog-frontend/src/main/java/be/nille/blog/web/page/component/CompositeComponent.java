/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page.component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class CompositeComponent implements Component {
    
    public List<Component> components;
    
    public CompositeComponent(){
        components = new ArrayList<>();
    }
    
    public CompositeComponent addComponent(final Component component){
        this.components.add(component);
        return this;
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        for(Component component : components){
            sb.append(component.render());
        }
        return sb.toString();
    }
    
}
