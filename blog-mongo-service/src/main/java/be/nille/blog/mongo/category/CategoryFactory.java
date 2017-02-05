/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.domain.category.DCategory;
import be.nille.blog.service.Category;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Niels Holvoet
 */
public class CategoryFactory{
    

    public Category create(final Document document){
       ObjectId objectId = document.getObjectId("_id");
       return new MCategory(objectId.toHexString(), new DCategory((String)document.get("description")));
    }
    
    
  
    
}
