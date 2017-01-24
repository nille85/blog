/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo.morphia.model;

import java.util.List;
import java.util.ArrayList;
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
public class MgPost {

    @Id
    private ObjectId id;

    @Reference
    private MgUser author;

    @Embedded
    private Content content;

    @Reference
    private MgCategory category;

    @Embedded
    private List<Comment> comments;

    public MgPost() {
        this.comments = new ArrayList<>();
    }

    public MgPost(final MgCategory category, final MgUser author, final Content content) {
        this.content = content;
        this.comments = new ArrayList<>();
        this.author = author;
        this.category = category;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Getter
    @ToString
    @Embedded
    public static class Comment {

        private String author;
        private String text;

        public Comment() {
        }

        public Comment(final String author, final String text) {
            this.text = text;
            this.author = author;
        }

    }

    @Getter
    @ToString
    @Embedded
    public static class Content {

        private String title;
        private String lead;

        public Content() {
        }

        public Content(final String title, final String lead) {
            this.title = title;
            this.lead = lead;
        }

    }

}
