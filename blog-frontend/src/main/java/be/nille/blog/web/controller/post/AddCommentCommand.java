/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.controller.post;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@Setter
public class AddCommentCommand {
    
    private String author;
    private String comment;
}
