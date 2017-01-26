package be.nille.blog.domain.post;

import be.nille.blog.domain.author.Author;
import be.nille.blog.domain.author.Content;
import be.nille.blog.domain.category.Category;






/**
 * Created by nholvoet on 26/01/2017.
 */
public interface PostFactory {

    Post create(final Author author, final Category category, final Content content);
}
