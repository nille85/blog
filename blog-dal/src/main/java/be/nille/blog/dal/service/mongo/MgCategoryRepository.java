/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.service.mongo;

import be.nille.blog.dal.mongo.morphia.model.MgCategory;
import be.nille.blog.dal.service.Category;
import be.nille.blog.dal.service.CategoryRepository;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Niels Holvoet
 */
public class MgCategoryRepository extends MgRepository<Category, MgCategory> implements CategoryRepository<String> {

    public MgCategoryRepository(final Datastore datastore) {
        super(datastore, MgCategory.class,new CategoryMapper());
        
    }
}
