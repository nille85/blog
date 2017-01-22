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
    
    Post findOne(String id);
    
    void add(Post post);
    
    void update(Post post);
    
    void remove(Post post);
    
    
    
    
    
}
