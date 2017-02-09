/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.Name;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Niels Holvoet
 */
@Entity(value="author",noClassnameStored = true)
@Getter
@ToString
public class MgAuthor implements Author  {
    
    @Id
    private ObjectId id;
    private String email;
    private String password;
    private Name name;
    
    public MgAuthor(){}
    
    public MgAuthor(final String email, final String password, final Name name){
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Override
    public String getId() {
        return id.toHexString();
    }

   
    
    
    
}
