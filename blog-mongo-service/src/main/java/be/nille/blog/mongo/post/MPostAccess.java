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

import be.nille.blog.domain.post.Post.Status;
import be.nille.blog.domain.post.PostAccess;
import be.nille.blog.mongo.author.MAuthorAccess;

import be.nille.blog.mongo.category.MCategoryAccess;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Niels Holvoet
 */
public class MPostAccess implements PostAccess {
    
    private final Document document;
    private final MongoDatabase database;
    
    public MPostAccess(final Document document,  final MongoDatabase database){
        this.document = document;
        this.database = database;
    }

    @Override
    public String getId() {
        return document.getObjectId("_id").toHexString();
    }

    @Override
    public Author getAuthor() {
        MongoCollection authorCollection = database.getCollection("author");
        ObjectId authorObjectId = (ObjectId) document.get("author");
        FindIterable<Document> iterable = authorCollection.find(Filters.eq("_id", authorObjectId));
        Document first = iterable.first();
        if(first != null){
           return new Author(new MAuthorAccess(first));
        }
        return null;
    }

    @Override
    public Content getContent() {
        Document dContent = (Document) document.get("content");
        Content content = null;
        if(dContent != null){
            content = new Content(dContent.getString("title"), dContent.getString("text"));
        }
        return content;
    }

    @Override
    public Category getCategory() {
        MongoCollection categoryCollection = database.getCollection("category");
        ObjectId categoryObjectId = (ObjectId) document.get("category");
        FindIterable<Document> iterable = categoryCollection.find(Filters.eq("_id", categoryObjectId));
        Document first = iterable.first();
        if(first != null){
           return new Category(new MCategoryAccess(first));
        }
        return null;
    }

    @Override
    public List<Comment> getComments() {
        List<Document> dComments = (List) document.get("comments");
        List<Comment> comments = new ArrayList<>();
        if(dComments != null){
            for(Document dComment : dComments){
                Comment comment = new Comment(dComment.getString("author"), dComment.getString("text"));
                comments.add(comment);
            }      
        }
        return comments;
    }

    @Override
    public Status getStatus() {
       
        return Status.valueOf(document.getString("status"));
    }

    @Override
    public Date getCreatedDate() {
        return document.getDate("createdDate");
    }
    
}
