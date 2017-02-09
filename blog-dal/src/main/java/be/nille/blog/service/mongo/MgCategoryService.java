package be.nille.blog.service.mongo;

import be.nille.blog.dal.MgCategory;
import be.nille.blog.domain.category.CategoryService;
import org.mongodb.morphia.Datastore;

import java.util.List;

/**
 * Created by nholvoet on 27/01/2017.
 */
public class MgCategoryService implements CategoryService {

    private final Datastore dataStore;

   
    public MgCategoryService(final Datastore dataStore){
        this.dataStore = dataStore;
    }


    @Override
    public List<MgCategory> findAll(){
        List<MgCategory> categories = dataStore.createQuery(MgCategory.class).asList();
        return categories;
    }


 }
