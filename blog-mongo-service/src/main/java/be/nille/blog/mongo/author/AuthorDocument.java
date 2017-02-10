/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.author;


import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.Name;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
public class AuthorDocumentFactory {
    
    public Document create(final Author author){
        Document document = new Document();
        Name name = author.getName();
        if(name != null){
            Document nameObject = new Document();
            nameObject.put("first", name.getFirst());
            nameObject.put("last", name.getLast());
            document.append("name", nameObject);
        }
        document.append("email", author.getEmail());
        document.append("password", author.getPassword());
        return document;
    }
    
    
    
    
}
