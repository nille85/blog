package be.nille.blog.domain;

/**
 * Created by nholvoet on 26/01/2017.
 */
public interface AuthorRepository {


    Author create(final String email, final Author.Name name);
}
