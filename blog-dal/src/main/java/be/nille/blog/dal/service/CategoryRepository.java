/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.service;

import java.util.List;

/**
 *
 * @author Niels Holvoet
 * @param <K> The unique id or key of a category
 */
public interface CategoryRepository<K> {
    
    Category add(Category category);
    
    void remove(Category category);
    
    List<Category> findAll();
    
    Category findOne(K key);
    
}
