/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.service.mongo;

import be.nille.blog.dal.mongo.morphia.model.MgCategory;
import be.nille.blog.dal.service.Category;

/**
 *
 * @author Niels Holvoet
 */
public class CategoryMapper extends MongoMapper<Category,MgCategory>{

   

    @Override
    protected Category createDomainObject(MgCategory mgCategory) {
        Category category = new Category(mgCategory.getDescription());
        category.setId(mgCategory.getId());
        return category;
    }

    @Override
    public MgCategory createMongoObject(Category domainObject) {
       return new MgCategory(domainObject.getDescription());
    }
   

}
