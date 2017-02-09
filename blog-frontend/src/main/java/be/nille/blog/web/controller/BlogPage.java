/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.controller;


import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.category.CategoryService;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public abstract class BlogPage {
    
    private final CategoryService categoryService;
    
    public BlogPage(final CategoryService categoryService){
        this.categoryService = categoryService;
    }
    
    public List<? extends Category> getCategories(){
        return categoryService.findAll();
    }
    
}
