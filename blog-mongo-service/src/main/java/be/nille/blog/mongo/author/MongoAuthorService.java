/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.author;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.AuthorService;
import be.nille.blog.domain.category.Category;
import be.nille.blog.mongo.MongoServiceException;
import be.nille.blog.mongo.category.CategoryDocument;
import be.nille.blog.mongo.category.MCategoryAccess;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Niels Holvoet
 */
public class MongoAuthorService implements AuthorService {

    private final MongoCollection collection;

    public MongoAuthorService(final MongoDatabase database) {
        this.collection = database.getCollection("author");
    }

    @Override
    public List<Author> findAll() {
        FindIterable<Document> iterable = collection.find();
        List<Author> list = new ArrayList<>();

        iterable.iterator().forEachRemaining(d -> list.add(new Author(new MAuthorAccess(d))));
        return list;
    }

    @Override
    public Author findById(String authorId) {
        FindIterable<Document> iterable = collection.find(Filters.eq("_id", new ObjectId(authorId)));
        Document first = iterable.first();
        if (first != null) {
            return new Author(new MAuthorAccess(first));
        }

        throw new MongoServiceException(String.format("Could not find author with id %s", authorId));

    }

    @Override
    public Author save(Author author) {
        Document document = new AuthorDocument(author).toDocument();
        if (author.getId() == null) {
            collection.insertOne(document);
            return new Author(new MAuthorAccess(document));
        }
        Bson filter = Filters.eq("_id", new ObjectId(author.getId()));
        collection.replaceOne(filter, document);
        return author;

    }

}
