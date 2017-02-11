/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.author;

import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@ToString
public class Author {
    
    private String id;
    private final Name name;
    private final String email;
    private final String password;
    
    public Author(final AuthorAccess authorAccess){
        this(authorAccess.getName(), authorAccess.getEmail(), authorAccess.getPassword());
        this.id = authorAccess.getId();
    }
    
    public Author(final Name name, final String email, final String password){
        this.id = null;
        this.name = name;
        this.email = email;
        this.password = password;
    }

   
    
}
