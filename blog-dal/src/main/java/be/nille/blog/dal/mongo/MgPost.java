/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo;

import be.nille.blog.dal.Comment;
import be.nille.blog.dal.Post;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class MgPost implements Post {
    
    private final Post origin;
    private final String id;
    
    public MgPost(final String id, final Post post){
        this.origin = post;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return origin.getTitle();
    }

    @Override
    public String getLead() {
        return origin.getLead();
    }

    @Override
    public List<Comment> getComments() {
        return origin.getComments();
    }
    
}
