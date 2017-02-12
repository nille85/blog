/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page;

import be.nille.blog.web.page.component.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class Placeholder implements Component {
    
    public List<Component> components;
    
    public Placeholder(){
        components = new ArrayList<>();
    }
    
    public Placeholder addComponent(final Component component){
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
