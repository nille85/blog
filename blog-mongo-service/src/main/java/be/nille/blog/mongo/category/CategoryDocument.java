/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.domain.category.Category;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
public class CategoryDocument {
    
    private final Category category;
    
    public CategoryDocument(final Category category){
        this.category = category;
    }
    
    public Document toDocument(){
        Document document = new Document();
        document.append("description", category.getDescription());
        return document;
    }
    
}
