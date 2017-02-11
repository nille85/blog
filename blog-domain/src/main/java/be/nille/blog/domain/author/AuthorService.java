/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.author;

import java.util.List;

/**
 *
 * @author nholvoet
 */
public interface AuthorService {
    
    List<Author> findAll();
    
    Author findById(String authorId);
    
    Author save(Author author);
}
