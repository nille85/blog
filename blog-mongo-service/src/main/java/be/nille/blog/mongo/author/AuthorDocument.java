/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.author;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.Name;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
public class AuthorDocument {

    private final Author author;

    public AuthorDocument(final Author author) {
        this.author = author;
    }

    public Document toDocument() {
        Document document = new Document();
        Name name = author.getName();
        if (name != null) {
            document.append("name", new NameDocument(name).toDocument());
        }
        document.append("email", author.getEmail());
        document.append("password", author.getPassword());
        return document;
    }

    public static class NameDocument {

        private final Name name;

        public NameDocument(final Name name) {
            this.name = name;
        }

        Document toDocument() {
            Document nameObject = new Document();
            nameObject.put("first", name.getFirst());
            nameObject.put("last", name.getLast());
            return nameObject;

        }

    }

}
