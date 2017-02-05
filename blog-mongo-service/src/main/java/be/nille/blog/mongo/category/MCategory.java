/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.domain.category.DCategory;
import be.nille.blog.service.Category;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.ToString;
import org.jongo.marshall.jackson.oid.MongoId;

/**
 *
 * @author Niels Holvoet
 */
@ToString
public class MCategory implements Category {
    
  
    private final String id;
    private final DCategory origin;
    

    public MCategory(final String id, final DCategory category){
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
