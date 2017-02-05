/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.author;

import be.nille.blog.service.Author;
import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class DAuthor implements Author {
    
    private final Name name;
    private final String email;
    private final String password;
    
    public DAuthor(final Name name, final String email, final String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
