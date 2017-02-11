/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.author;

import be.nille.blog.domain.author.AuthorAccess;
import be.nille.blog.domain.author.Name;
import lombok.ToString;
import org.bson.Document;


/**
 *
 * @author Niels Holvoet
 */
@ToString
public class MAuthorAccess implements AuthorAccess {
    
    private final Document document;
    

    public MAuthorAccess(final Document document){
       this.document = document;
    }

    @Override
    public String getId() {
        return document.getObjectId("_id").toHexString();
    }

    @Override
    public String getEmail() {
        return document.getString("email");
    }

    @Override
    public String getPassword() {
        return document.getString("password");
    }

    @Override
    public Name getName() {
        Document dName = (Document) document.get("name");
        Name name = null;
        if(dName != null){
            name = new Name(dName.getString("first"), dName.getString("last"));
        }
        return name;
    }
    
}
