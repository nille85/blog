/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.author;

import be.nille.blog.service.Author.Name;
import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class DName implements Name {
    
    private final String first;
    private final String last;
    
    public DName(final String first, final String last){
        this.first = first;
        this.last = last;
    }

   
    
}
