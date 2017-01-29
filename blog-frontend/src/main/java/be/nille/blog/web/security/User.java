/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.security;

import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class User {
    
    private final String email;
    
    public User(final String email){
        this.email = email;
    }
    
}
