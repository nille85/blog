/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component.navigation;

import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class Blog {
    
    private final String title;
    
    public Blog(final String title){
        this.title = title;
    }
    
}
