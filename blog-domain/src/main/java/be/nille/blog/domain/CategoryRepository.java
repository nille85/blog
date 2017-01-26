package be.nille.blog.domain;

/**
 * Created by nholvoet on 26/01/2017.
 */
public interface CategoryRepository {

    Category create(final String description);
}
