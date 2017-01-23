/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo;

import be.nille.blog.dal.DPost;
import be.nille.blog.dal.Entity;
import be.nille.blog.dal.Post;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author nholvoet
 * @param <T> the type of the items in repository
 */
public abstract class MongoRepository<T extends Entity> {

    private final MongoCollection collection;

    public MongoRepository(final MongoCollection collection) {
        this.collection = collection;
    }

    public List<T> findAll() {
        
        return iterableToEntities(collection.find());
        
    }

    public List<T> findAll(final int skip, final int limit) {
        FindIterable<Document> iterable = collection.find()
                .skip(skip)
                .limit(limit);
        return iterableToEntities(iterable);
    }
    
    
    private List<T> iterableToEntities(final FindIterable iterable){
        List<T> entries = new ArrayList<>();
        try (MongoCursor<Document> cursor = iterable.iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                T entry = fromDocument(document);
                entries.add(entry);
            }
        }
        return entries;
    }

    public Optional<T> findOne(String id) {
        Bson bson = eq("_id", new ObjectId(id));
        FindIterable<Document> iterable = collection.find(bson);

        Document document = iterable.first();
        if (document != null) {
            return Optional.of(fromDocument(document));
        }
        return Optional.empty();
    }

    public void add(final T entity) {
        collection.insertOne(fromEntity(entity));
    }

    public void update(final T entity) {
        Bson bson = eq("_id", entity.getId());
        collection.updateOne(bson, fromEntity(entity));
    }

    public void remove(final T entity) {
        Bson bson = eq("_id", entity.getId());
        collection.deleteOne(bson);
    }

    public abstract T fromDocument(Document document);

    public abstract Document fromEntity(final T entity);

}
