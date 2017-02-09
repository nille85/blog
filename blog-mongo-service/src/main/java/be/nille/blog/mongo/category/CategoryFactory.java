/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo.category;

import be.nille.blog.domain.category.DCategory;
import be.nille.blog.domain.category.Category;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Category category = create();
        try {
            BeanUtils.setProperty(category, "description", document.getString("description"));
            return new MCategory(objectId.toHexString(), category);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex.toString(), ex);
        }

    }

    private Category create() {
        try {
            Class<?> c = Class.forName(DCategory.class.getName());
            Constructor<?> constructor = c.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object category = constructor.newInstance();

            return (Category) category;
        } catch (IllegalArgumentException | InvocationTargetException | InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException ex) {
            throw new RuntimeException(ex.toString(), ex);
        }
    }

}
