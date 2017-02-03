/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author nholvoet
 */
public interface Post {

    String getyId();

    Author getAuthor();

    Content getContent();

    Category getCategory();

    List<Comment> getComments();

    Status getStatus();

    Date getCreatedDate();

    void publish();

    void addComment(Comment comment);

    public interface Comment {

        String getAuthor();

        String getText();

        Date getCreatedDate();
    }

    public interface Content {

        String getTitle();

        String getText();

    }

    public static enum Status {

        DRAFT, PUBLISHED
    }

}
