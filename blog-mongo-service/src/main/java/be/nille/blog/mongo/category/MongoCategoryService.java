/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.category.CategoryService;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
public class MongoCategoryService implements CategoryService {
    
    private final MongoCollection collection;
    
    public MongoCategoryService(final MongoCollection collection){
        this.collection = collection;
    }

 
    @Override
    public List<Category> findAll() {
        FindIterable<Document> iterable = collection.find();
        List<Category> list = new ArrayList<>();
        CategoryFactory factory = new CategoryFactory();
        iterable.iterator().forEachRemaining(d -> list.add(factory.create(d)));
        return list;
    }
    
    
    public void insert(final Category category){
        CategoryDocumentFactory factory = new CategoryDocumentFactory();
        Document document = factory.create(category);
        collection.insertOne(document);
    }
    
}
