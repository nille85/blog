/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class Comment {
    
    private final String text;
    
    public Comment(final String text){
        this.text = text;
    }
    
}
