/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo.morphia;

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

/**
 *
 * @author Niels Holvoet
 */
@Entity("posts")
@Indexes(
        @Index(fields = @Field("title"))
)
@Getter
@ToString
public class Post {

    @Id
    private ObjectId id;
    private String title;

    private String lead;

    @Embedded
    private List<Comment> comments;
    
    public Post(){
        this.comments = new ArrayList<>();
    }

    public Post(final String title, final String lead) {
        this.title = title;
        this.lead = lead;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

}
