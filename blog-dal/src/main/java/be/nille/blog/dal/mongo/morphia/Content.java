/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo.morphia;

import lombok.Getter;
import lombok.ToString;
import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@ToString
@Embedded
public class Content {
    
    private String title;
    private String lead;
    
    public Content(){}
    
    public Content(final String title, final String lead){
        this.title = title;
        this.lead = lead;
    }
    
}
