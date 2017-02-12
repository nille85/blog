/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page.template;

import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class TemplateModel {
    
    private final String name;
    private final Object value;
    
    public TemplateModel(final String name, final Object value){
        this.name = name;
        this.value = value;
    }
    
}
