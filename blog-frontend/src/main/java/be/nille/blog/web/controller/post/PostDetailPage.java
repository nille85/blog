package be.nille.blog.web.controller.post;


import be.nille.blog.domain.category.Category;
import be.nille.blog.domain.post.Post;
import java.util.List;
import lombok.Getter;




/**
 * Created by nholvoet on 27/01/2017.
 */
@Getter
public final class PostDetailPage {

    private final Post post;
    private final List<Category> categories;

    public PostDetailPage(final Post post, final List<Category> categories){
        this.post = post;
        this.categories = categories;    
    }

  
}
