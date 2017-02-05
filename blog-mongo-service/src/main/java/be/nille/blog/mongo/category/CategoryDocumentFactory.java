/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.service.Category;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
public class CategoryDocumentFactory {
    
    public Document create(final Category category){
        Document document = new Document();
        document.append("description", category.getDescription());
        return document;
    }
    
}
