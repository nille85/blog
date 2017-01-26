/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Niels Holvoet
 */
@Entity("author")
@Getter
@ToString
public class Author {
    
    @Id
    private ObjectId id;
    private String email;
    private Name name;
    
    public Author(){}
    
    public Author(final String email, final Name name){
        this.email = email;
        this.name = name;
    }
    
    @Getter
    @ToString
    public static class Name{
        
        private String first;
        private String last;
        
        public Name(){}
        
        public Name(final String first, final String last){
            this.first = first;
            this.last = last;
        }
    }
    
}
