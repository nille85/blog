/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.category;

import be.nille.blog.domain.category.Category;
import java.util.List;

/**
 *
 * @author nholvoet
 */
public interface CategoryService {
    
    List<? extends Category> findAll();
}
