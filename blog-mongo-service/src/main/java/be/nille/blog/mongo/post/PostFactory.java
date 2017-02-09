/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.post;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.post.Comment;
import be.nille.blog.domain.post.Content;
import be.nille.blog.domain.post.Post;
import be.nille.blog.domain.post.Post.Status;
import be.nille.blog.mongo.author.AuthorFactory;
import be.nille.blog.mongo.category.CategoryFactory;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Niels Holvoet
 */
public class PostFactory {
    
    private final MongoDatabase database;
    
    public PostFactory(final MongoDatabase database){
        this.database = database;
    }
    
  
    public Post create(final Document document) {
        ObjectId objectId = document.getObjectId("_id");
        
        PPost post = new PPost();
        
        reconstituteAuthor(document)
                .ifPresent(author -> post.setAuthor(author));
        reconstituteCategory(document)
                .ifPresent(category -> post.setCategory(category));
        
        post.setCreatedDate(document.getDate("createdDate"));
        post.setStatus(document.get("status", Status.class));
      
        Document dContent = (Document) document.get("content");
        Content content = null;
        if(dContent != null){
            content = new Content(dContent.getString("title"), dContent.getString("text"));
        }
        post.setContent(content);
        
        List<Document> dComments = (List) document.get("comments");
        if(dComments != null){
            List<Comment> comments = new ArrayList<>();
            for(Document dComment : dComments){
                Comment comment = new Comment(dComment.getString("author"), dComment.getString("text"));
                comments.add(comment);
            }
            post.setComments(comments);
        }
        
        return new MPost(objectId.toHexString(), post);
    }
    
    
    private Optional<Category> reconstituteCategory(final Document document){
        MongoCollection categoryCollection = database.getCollection("category");
        ObjectId categoryObjectId = (ObjectId) document.get("category");
        FindIterable<Document> iterable = categoryCollection.find(Filters.eq("_id", categoryObjectId));
        Document first = iterable.first();
        if(first != null){
           return Optional.of(new CategoryFactory().create(first));
        }
        return Optional.empty();   
    }
    
    private Optional<Author> reconstituteAuthor(final Document document){
        MongoCollection authorCollection = database.getCollection("author");
        ObjectId authorObjectId = (ObjectId) document.get("author");
        FindIterable<Document> iterable = authorCollection.find(Filters.eq("_id", authorObjectId));
        Document first = iterable.first();
        if(first != null){
           return Optional.of(new AuthorFactory().create(first));
        }
        return Optional.empty();   
    }
    
    @Getter
    @Setter
    private class PPost implements Post{
        
        private Author author;
        private Content content;
        private Category category;
        private List<Comment> comments;
        private Status  status;
        private Date createdDate;
        

        @Override
        public String getId() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Author getAuthor() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Content getContent() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Category getCategory() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<Comment> getComments() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Status getStatus() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Date getCreatedDate() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void publish() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addComment(Comment comment) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    } 
}
