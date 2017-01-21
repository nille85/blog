/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public interface Posts {
    
    
    List<Post> findAll();
    
    void add(final Post post);
    
    void update(final Post post);
    
    void remove(final Post post);
    
    
    
    
    
}
