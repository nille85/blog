/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.domain.post.Post;
import be.nille.blog.mongo.MongoServiceException;
import be.nille.blog.mongo.post.MPostAccess;
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
public class MongoCategoryService implements CategoryService {

    private final MongoCollection collection;

    public MongoCategoryService(final MongoDatabase database) {
        this.collection = database.getCollection("category");
    }

    @Override
    public List<Category> findAll() {
        FindIterable<Document> iterable = collection.find();
        List<Category> list = new ArrayList<>();

        iterable.iterator().forEachRemaining(d -> list.add(new Category(new MCategoryAccess(d))));
        return list;
    }

    @Override
    public Category findById(String categoryId) {
        FindIterable<Document> iterable = collection.find(Filters.eq("_id", new ObjectId(categoryId)));
        Document first = iterable.first();
        if (first != null) {
            return new Category(new MCategoryAccess(first));
        }

        throw new MongoServiceException(String.format("Could not find category with id %s", categoryId));

    }

    @Override
    public Category save(Category category) {
        Document document = new CategoryDocument(category).toDocument();
        if (category.getId() == null) {
            collection.insertOne(document);
            return new Category(new MCategoryAccess(document));
        }
        Bson filter = Filters.eq("_id", new ObjectId(category.getId()));
        collection.replaceOne(filter, document);
        return category;

    }

}
