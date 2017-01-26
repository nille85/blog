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
@Entity("category")
@Getter
@ToString
public class Category{
    
    @Id
    private ObjectId id;
    
    private String description;
    
    
    public Category(){}
    
    public Category(final String description){
        this.description = description;
    }
    
}
