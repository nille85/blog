package be.nille.blog.service;

import be.nille.blog.dal.Category;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nholvoet on 27/01/2017.
 */
@Service
public class CategoryService {

    private final Datastore dataStore;

    @Autowired
    public CategoryService(final Datastore dataStore){
        this.dataStore = dataStore;
    }


    public List<Category> findAll(){
        List<Category> categories = dataStore.createQuery(Category.class).asList();
        return categories;
    }


 }
