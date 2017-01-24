/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.service;

import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@ToString
public class AddComment<K> {
    
    private final K postId;
    private final String author;
    private final String comment;
    
    public AddComment(final K postId, final String author, final String comment){
        this.postId = postId;
        this.author = author;
        this.comment = comment;
    }
    
    
    
}
