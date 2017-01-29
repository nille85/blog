/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

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
public class Post {

    @Id
    private ObjectId id;

    @Reference
    private Author author;

    @Embedded
    private Content content;

    @Reference
    private Category category;

    @Embedded
    private List<Comment> comments;
    
    private Status status;
    
    private final Date createdDate;

    /*
    *For Morphia
    */
    public Post() {
        this(null,null,null);
    }

    public Post(final Category category, final Author author, final Content content) {
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

    @Getter
    @ToString
    @Embedded
    public static class Comment {

        
        private String author;
        private String text;
        private Date createdDate;

        public Comment() {
        }

        public Comment(final String author, final String text) {
            this.text = text;
            this.author = author;
            this.createdDate = new Date();
        }

       

    }

    @Getter
    @ToString
    @Embedded
    public static class Content {

        private String title;
        private String text;

        public Content() {
        }

        public Content(final String title, final String text) {
            this.title = title;
            this.text = text;
        }

    }
    
    public static enum Status {
        DRAFT, PUBLISHED
    }

}
