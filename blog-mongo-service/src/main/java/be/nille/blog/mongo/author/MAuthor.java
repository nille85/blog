/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.author;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.DAuthor;
import be.nille.blog.domain.author.Name;
import lombok.ToString;


/**
 *
 * @author Niels Holvoet
 */
@ToString
public class MAuthor implements Author {
    
    private final String id;
    private final Author origin;
    

    public MAuthor(final String id, final Author author){
        this.id = id;
        this.origin = author;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return origin.getEmail();
    }

    @Override
    public String getPassword() {
        return origin.getPassword();
    }

    @Override
    public Name getName() {
        return origin.getName();
    }
    
}
