/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.post;


import be.nille.blog.service.PageInfo;
import java.util.List;

/**
 *
 * @author nholvoet
 */
public interface PostService {
    
    List<Post> findAll();
    
    List<Post> findByPageInfo(final PageInfo pageInfo);
    
    List<Post> findPostsByCategory(final String categoryId);
    
    List<Post> fullTextPostSearch(final String searchValue);
    
    long getNumberOfPosts();
    
    Post findPostById(final String postId);
    
    Post save(Post post);
}
