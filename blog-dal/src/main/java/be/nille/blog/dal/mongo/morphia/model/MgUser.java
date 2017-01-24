/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo.morphia.model;

import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Niels Holvoet
 */
@Entity("user")
@Getter
@ToString
public class MgUser {
    
    @Id
    private ObjectId id;
    private String email;
    private String password;
    
    public MgUser(){}
    
    public MgUser(final String email, final String password){
        this.email = email;
        this.password = password;
    }
    
}
