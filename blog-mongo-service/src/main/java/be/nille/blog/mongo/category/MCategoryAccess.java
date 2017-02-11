/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.category.CategoryAccess;
import lombok.ToString;
import org.bson.Document;


/**
 *
 * @author Niels Holvoet
 */
@ToString
public class MCategoryAccess implements CategoryAccess {
    
    private final Document document;
  
    public MCategoryAccess(final Document document){
        this.document = document;
    }
   
    @Override
    public String getId() {
         return document.getObjectId("_id").toHexString();
    }

    @Override
    public String getDescription() {
        return document.getString("description");
    }
    
}
