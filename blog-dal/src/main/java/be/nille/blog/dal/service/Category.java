/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@ToString
public class Category<K> extends DomainEntity<K> {

    @Setter
    private K id;
    
    private final String description; 
    
    public Category(String description){
        this.description = description;
    }
    
    
    
    
    
}
