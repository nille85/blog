/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongodb;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.AuthorFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Niels Holvoet
 */
public class AuthorFactoryImpl implements AuthorFactory{
    
    private final MongoCollection collection;
    
    public AuthorFactoryImpl(final MongoCollection collection){
        this.collection = collection;
    }

    @Override
    public Author create(String email, Author.Name name) {
        
        Document doc = new Document();
        doc.append("email", email)
           .append("name", new BasicDBObject()
                            .append("first",name.getFirst())
                            .append("last", name.getLast())
           );
        collection.insertOne(doc);
        ObjectId id = (ObjectId)doc.get( "_id" );
        return new Author(id.toHexString(), email, name);
    }
    
}
