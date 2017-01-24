/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component.post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;




/**
 *
 * @author nholvoet
 */
@Getter
@Setter
@ToString
public class PostCommentRequest {
    
    
    private String id;
    private String author;
    private String comment;
   
   
}
