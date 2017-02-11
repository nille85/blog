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
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Niels Holvoet
 */
public class PostDocumentFactory {
    
    public Document create(final Post post){
        Document document = new Document();
        Author author = post.getAuthor();
        if(author != null){  
           document.append("author", new ObjectId(author.getId()));
        }  
        Category category = post.getCategory();
        if(category != null){
            document.append("category", new ObjectId(category.getId()));
        }       
        Content content = post.getContent();
        if(content != null){
            document.append("content", createContentDocument(content));
        }
        
        List<Comment> comments = post.getComments();
        document.append("comments", createCommentsDocuments(comments));
               
        document.append("status", post.getStatus().toString());
        document.append("createdDate", post.getCreatedDate());
        return document;
    }
    
    private Document createContentDocument(final Content content){
        
            Document document = new Document();
            document.append("title", content.getTitle());
            document.append("text", content.getText());
           
            return document;
        
    }

    private List<Document> createCommentsDocuments(List<Comment> comments) {
        List<Document> documents = new ArrayList<>();
        for(Comment comment : comments){
            Document document = new Document();
            document.append("author", comment.getAuthor());
            document.append("createdDate", comment.getCreatedDate());
            document.append("text", comment.getText());
            documents.add(document);
        }
        return documents;
    }
    
}
