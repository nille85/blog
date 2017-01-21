/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

import lombok.Getter;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class DPost implements Post{
    
   
    
    private final String title;
    
    private final String lead;
    
    public DPost(final String title, final String lead){
        this.title = title;
        this.lead = lead;
    }
    
    public Document toDocument() {
        Document document = new Document();
       
        return document.append("title", title)
                .append("lead", lead);
    }

    @Override
    public String getId() {
        throw new RuntimeException("Id is not available because this post was not saved yet");
    }
    
}
