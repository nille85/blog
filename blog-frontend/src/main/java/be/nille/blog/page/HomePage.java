package be.nille.blog.page;

import be.nille.blog.dal.Category;
import be.nille.blog.dal.Post;
import be.nille.blog.service.CategoryService;
import be.nille.blog.service.PostService;
import lombok.Getter;

import java.util.List;


/**
 * Created by nholvoet on 27/01/2017.
 */
public final class HomePage {

    private final CategoryService categoryService;
    private final PostService postService;
    @Getter
    private final PageInfo pageInfo;


    public HomePage(final CategoryService categoryService, final PostService postService, final PageInfo pageInfo){
        this.categoryService = categoryService;
        this.postService = postService;
        this.pageInfo = pageInfo;
    }

    public List<Post> getPosts(){
        final int pageNumber = pageInfo.getPageNumber();
        final int numberOfPostsInPage = pageInfo.getNumberOfItemsInPage();
        final int offset = pageNumber * numberOfPostsInPage;
        final int limit = offset + numberOfPostsInPage;
        return postService.findByOffsetAndLimit(offset, limit);
    }

    public List<Category> getCategories(){
        return categoryService.findAll();
    }

}
