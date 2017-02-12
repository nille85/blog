/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page.component;

/**
 *
 * @author Niels Holvoet
 */
public class StringComponent implements Component {
    
    private final String value;
    
    public StringComponent(final String value){
        this.value = value;
    }

    @Override
    public String render() {
        return value;
    }
    
}
