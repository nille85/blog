/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.service;

/**
 *
 * @author Niels Holvoet
 * @param <K> The unique key of a post object
 */
public interface PostService<K> {
    
    void addCommentToPost(AddComment<K> comment);
    
 
    
}
