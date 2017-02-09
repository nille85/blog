package be.nille.blog.web.controller.post;

import be.nille.blog.web.controller.BlogPage;
import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.service.PageInfo;
import be.nille.blog.domain.post.Post;
import be.nille.blog.domain.post.PostService;
import be.nille.blog.web.controller.PostsPage;

import lombok.Getter;

import java.util.List;
import lombok.extern.slf4j.Slf4j;


/**
 * Created by nholvoet on 27/01/2017.
 */
@Slf4j
public final class SearchPostsPage extends BlogPage implements PostsPage {

   
    private final PostService postService;
  
    private final String searchValue;


    public SearchPostsPage(final CategoryService categoryService, final PostService postService, final String searchValue){
        super(categoryService);
        this.postService = postService;
       
        this.searchValue = searchValue;
    }

    @Override
    public List<? extends Post> getPosts(){
        List<? extends Post> posts = postService.fullTextPostSearch(searchValue);
        log.info("size of posts: " + posts.size());
        return posts;
    }
    
    

}
