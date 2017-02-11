/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.author;

/**
 *
 * @author Niels Holvoet
 */
public interface AuthorAccess {
    
    String getId();

    String getEmail();

    String getPassword();

    Name getName();

    
}
