package be.nille.blog.domain;

import java.util.List;

/**
 * Created by nholvoet on 26/01/2017.
 */
public interface CategoryRepository {


    Category findOne(String id);

    List<Category> findAll();

    void save(Category category);

    void delete(Category category);

}
