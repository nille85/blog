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
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
public class MongoCategoryService implements CategoryService {
    
    private final MongoCollection collection;
    
    public MongoCategoryService(final MongoDatabase database){
        this.collection = database.getCollection("category");
    }

 
    @Override
    public List<Category> findAll() {
        FindIterable<Document> iterable = collection.find();
        List<Category> list = new ArrayList<>();
      
        iterable.iterator().forEachRemaining(d -> list.add(new MCategory(d)));
        return list;
    }
    
    
    public void insert(final Category category){
        CategoryDocument cDocument = new CategoryDocument(category);
        collection.insertOne(cDocument.toDocument());
    }
    
}
