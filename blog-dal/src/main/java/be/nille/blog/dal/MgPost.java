/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

import be.nille.blog.service.Post;
import be.nille.blog.service.Post.Comment;
import be.nille.blog.service.Post.Content;
import be.nille.blog.service.Post.Status;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author Niels Holvoet
 */
@Entity("post")
@Indexes(
        @Index(fields = @Field("title"))
)
@Getter
@ToString
public class MgPost implements Post {

    @Id
    private ObjectId id;

    @Reference
    private MgAuthor author;

    @Embedded
    private Content content;

    @Reference
    private MgCategory category;

    @Embedded
    private List<Comment> comments;
    
    private Status status;
    
    private final Date createdDate;

    /*
    *For Morphia
    */
    public MgPost() {
        this(null,null,null);
    }

    public MgPost(final MgCategory category, final MgAuthor author, final Content content) {
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
    public String getyId() {
        return id.toHexString();
    }

    @Getter
    @ToString
    @Embedded
    public static class MgComment implements Comment {

        
        private String author;
        private String text;
        private Date createdDate;

        public MgComment() {
        }

        public MgComment(final String author, final String text) {
            this.text = text;
            this.author = author;
            this.createdDate = new Date();
        }

       

    }

    @Getter
    @ToString
    @Embedded
    public static class MgContent implements Content {

        private String title;
        private String text;

        public MgContent() {
        }

        public MgContent(final String title, final String text) {
            this.title = title;
            this.text = text;
        }

    }
    
    

}
