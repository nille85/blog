package be.nille.blog.service;

import be.nille.blog.dal.MgCategory;
import org.mongodb.morphia.Datastore;

import java.util.List;

/**
 * Created by nholvoet on 27/01/2017.
 */
public class CategoryService {

    private final Datastore dataStore;

   
    public CategoryService(final Datastore dataStore){
        this.dataStore = dataStore;
    }


    public List<MgCategory> findAll(){
        List<MgCategory> categories = dataStore.createQuery(MgCategory.class).asList();
        return categories;
    }


 }
