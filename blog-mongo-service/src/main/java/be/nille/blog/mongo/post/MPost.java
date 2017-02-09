/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.post;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.post.Comment;
import be.nille.blog.domain.post.Content;
import be.nille.blog.domain.post.Post;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class MPost implements Post {
    
    private final String id;
    private final Post origin;
    
    public MPost(final String id, final Post post){
        this.id = id;
        this.origin = post;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Author getAuthor() {
        return origin.getAuthor();
    }

    @Override
    public Content getContent() {
        return origin.getContent();
    }

    @Override
    public Category getCategory() {
        return origin.getCategory();
    }

    @Override
    public List<Comment> getComments() {
        return origin.getComments();
    }

    @Override
    public Status getStatus() {
        return origin.getStatus();
    }

    @Override
    public Date getCreatedDate() {
        return origin.getCreatedDate();
    }

    @Override
    public void publish() {
        origin.publish();
    }

    @Override
    public void addComment(Comment comment) {
        origin.addComment(comment);
    }
    
}
