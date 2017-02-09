/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.domain.category.Category;
import lombok.ToString;


/**
 *
 * @author Niels Holvoet
 */
@ToString
public class MCategory implements Category {
    
  
    private final String id;
    private final Category origin;
    

    public MCategory(final String id, final Category category){
        this.id = id;
        this.origin = category;
    }
    
   

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return origin.getDescription();
    }
    
}
