package be.nille.blog.domain.category;

/**
 * Created by nholvoet on 26/01/2017.
 */
public interface CategoryFactory {

    Category create(final String description);
}
