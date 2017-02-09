/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.post;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.category.Category;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class DPost implements Post{
    
    private Content content;
    private Author author;
    private Category category;
    private final List<Comment> comments;
    private Status status;
    private Date createdDate;
    
    
     public DPost(final Category category, final Author author, final Content content) {
        this.content = content;
        this.comments = new ArrayList<>();
        this.author = author;
        this.category = category;
        this.status = Status.DRAFT;
        this.createdDate = new Date();
    }
    
    @Override
    public void publish(){
        this.status = Status.PUBLISHED;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(0,comment);
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
