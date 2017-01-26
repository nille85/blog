package be.nille.blog.domain;

/**
 * Created by nholvoet on 26/01/2017.
 */
public interface PostFactory {

    Post create(final Author author, final Category category, final Content content);
}
