/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.post;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.category.Category;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nholvoet
 */
public interface Post {

    String getId();

    Author getAuthor();

    Content getContent();

    Category getCategory();

    List<Comment> getComments();

    Status getStatus();

    Date getCreatedDate();

    void publish();

    void addComment(Comment comment);

   

    public static enum Status {

        DRAFT, PUBLISHED
    }

}
