/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo.morphia;

import lombok.Getter;
import lombok.ToString;
import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@ToString
@Embedded
public class Comment {
    
    private String author;
    private String text;
    
    public Comment(){}
    
    public Comment(final String author, final String text){
        this.text = text;
        this.author = author;
    }
    
}
