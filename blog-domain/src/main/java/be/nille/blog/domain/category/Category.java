/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.category;

import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@ToString
public class Category{
    
    private String id;
    private String description;
    
    public Category(final CategoryAccess categoryAccess){
        this(categoryAccess.getDescription());
        this.id = categoryAccess.getId();
    }
    
    public Category(final String description){
        this.id = null;
        this.description = description;
    }    

    
    
    
    
}
