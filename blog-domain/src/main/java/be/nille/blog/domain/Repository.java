package be.nille.blog.domain;


import java.util.List;

/**
 * Created by Niels on 26/01/2017.
 */
public interface Repository<T> {

    T findOne(String id);

    List<T> findAll();

    void save(T entity);

    void delete(T entity);
}
