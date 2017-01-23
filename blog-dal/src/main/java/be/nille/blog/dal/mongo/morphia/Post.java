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
import org.mongodb.morphia.annotations.Reference;

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
    
    @Reference
    private User author;

    @Embedded
    private Content content;
    
    @Reference
    private Category category;

    @Embedded
    private List<Comment> comments;
    
    public Post(){
        this.comments = new ArrayList<>();
    }

    public Post(final Category category, final User author, final Content content) {
        this.content = content;
        this.comments = new ArrayList<>();
        this.author = author;
        this.category = category;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

}
