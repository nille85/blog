/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.domain.category.DCategory;
import be.nille.blog.domain.category.Category;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Niels Holvoet
 */
public class CategoryFactory {

    public Category create(final Document document) {
        ObjectId objectId = document.getObjectId("_id");
        try {
            Class<?> c = Class.forName(DCategory.class.getName());
            Constructor<?> constructor = c.getDeclaredConstructor();
            constructor.setAccessible(true);
            Category category = DCategory.class.newInstance();
            BeanUtils.setProperty(category, "description", document.get("description"));
            return new MCategory(objectId.toHexString(), category);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException ex) {
            throw new RuntimeException(ex.toString());
        }
    }

}
