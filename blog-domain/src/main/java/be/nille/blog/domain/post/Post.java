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
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@ToString
public class Post{
    
    private String id;
    private Content content;
    private Author author;
    private Category category;
    private final List<Comment> comments;
    private Status status;
    private Date createdDate;
    
    
    public Post(final PostAccess postAccess){
        this.id = postAccess.getId();
        this.content = postAccess.getContent();
        this.category = postAccess.getCategory();
        this.author = postAccess.getAuthor();
        this.status = postAccess.getStatus();
        this.createdDate = postAccess.getCreatedDate();
        this.comments = postAccess.getComments();
    }
    
    public Post(final Category category, final Author author, final Content content) {
        this.id = null;
        this.content = content;
        this.comments = new ArrayList<>();
        this.author = author;
        this.category = category;
        this.status = Status.DRAFT;
        this.createdDate = new Date();
    }
        

    public void publish(){
        this.status = Status.PUBLISHED;
    }


    public void addComment(Comment comment) {
        comments.add(0,comment);
    }


    
    public static enum Status {

        DRAFT, PUBLISHED
    }

    

    
}
