/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class DPost implements Post{
    
   
    
    private final String title;
    
    private final String lead;
    
    private final List<Comment> comments;
    
    public DPost(final String title, final String lead){
        this(title,lead,new ArrayList<>());
    }
    
    public DPost(final String title, final String lead, final List<Comment> comments){
        this.title = title;
        this.lead = lead;
        this.comments = comments;
    }
    
    @Override
    public String getId() {
        throw new RuntimeException("Id is not available because this post was not saved yet");
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }
    
}
