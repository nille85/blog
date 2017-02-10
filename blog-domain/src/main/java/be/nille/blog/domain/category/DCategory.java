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
public class DCategory implements Category{
    
    private String description;
    
    private DCategory(final Category category){
        this(category.getDescription());
    }
    
    public DCategory(final String description){
        this.description = description;
    }    

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
}
