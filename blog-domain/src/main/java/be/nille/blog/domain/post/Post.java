package be.nille.blog.domain.post;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.Comment;
import be.nille.blog.domain.author.Content;
import be.nille.blog.domain.category.Category;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


/**
 * Created by nholvoet on 26/01/2017.
 */
@Getter
public final class Post {

    private final Author author;
    private Category category;
    private final Content content;
    private final List<Comment> comments;
    private Status status;
    private final LocalDate createdDate;

    Post(final Author author, final Category category, final Content content){
        this.author = author;
        this.category = category;
        this.content = content;
        this.comments = new ArrayList<>();
        this.status = Status.DRAFT;
        this.createdDate = LocalDate.now();
    }

    public void addComment(final Comment comment){
        this.comments.add(comment);
    }

    public void changeCategory(final Category category){
        this.category = category;
    }

    public void publish(){
        this.status = Status.PUBLISHED;
    }

    public static enum Status{
        DRAFT, PUBLISHED
    }
}
