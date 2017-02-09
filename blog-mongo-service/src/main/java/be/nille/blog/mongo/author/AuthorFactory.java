/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.author;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.DAuthor;
import be.nille.blog.domain.author.Name;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Niels Holvoet
 */
public class AuthorFactory {

    public Author create(final Document document) {
        ObjectId objectId = document.getObjectId("_id");
        Document dName = (Document) document.get("name");
        Name name = null;
        if(dName != null){
            name = new Name(dName.getString("first"), dName.getString("last"));
        }
        DAuthor author = new DAuthor(name, document.getString("email"), document.getString("password"));
        return new MAuthor(objectId.toHexString(), author);
    }

}
