package be.nille.blog.domain.author;

/**
 * Created by nholvoet on 26/01/2017.
 */
public interface AuthorFactory {


    Author create(final String email, final Author.Name name);
}