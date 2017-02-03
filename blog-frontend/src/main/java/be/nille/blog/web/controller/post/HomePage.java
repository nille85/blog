package be.nille.blog.web.controller.post;

import be.nille.blog.dal.MgCategory;
import be.nille.blog.dal.MgPost;
import be.nille.blog.service.CategoryService;
import be.nille.blog.service.PostService;
import be.nille.blog.web.page.PageInfo;
import lombok.Getter;

import java.util.List;


/**
 * Created by nholvoet on 27/01/2017.
 */
public final class HomePage extends BlogPage {

   
    private final PostService postService;
    @Getter
    private final PageInfo pageInfo;


    public HomePage(final CategoryService categoryService, final PostService postService, final PageInfo pageInfo){
        super(categoryService);
        this.postService = postService;
        this.pageInfo = pageInfo;
    }

    public List<MgPost> getPosts(){
        return postService.findByOffsetAndLimit(pageInfo);
    }

}
