/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.post;

import java.util.Date;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@ToString
public class Comment {

    private final String author;
    private final String text;
    private final Date createdDate;

    public Comment(final String author, final String text) {
        this.text = text;
        this.author = author;
        this.createdDate = new Date();
    }
    
    

}
