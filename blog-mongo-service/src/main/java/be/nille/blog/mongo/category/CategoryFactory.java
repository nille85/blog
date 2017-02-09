/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.domain.category.DCategory;
import be.nille.blog.domain.category.Category;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.beanutils.BeanUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Niels Holvoet
 */
public class CategoryFactory {

    public Category create(final Document document) {
        ObjectId objectId = document.getObjectId("_id");
        return new MCategory(objectId.toHexString(), new PCategory(document.getString("description")));
    }
    
    @Getter
    @Setter
    @ToString
    private class PCategory implements Category{
        
        private String description;
        
        public PCategory(final String description){
            
            this.description = description;
        }

        @Override
        public String getId() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        
    
    }


}
