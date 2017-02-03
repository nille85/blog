/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.service;

/**
 *
 * @author nholvoet
 */
public interface Author {
    
    String getId();
    String getEmail();
    String getPassword();
    Name getName();
    
    public interface Name{
        
        String getFirst();
        String getLast();
    }
    
}
