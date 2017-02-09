/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.post;


import be.nille.blog.domain.post.Comment;
import be.nille.blog.domain.post.Post;
import be.nille.blog.service.PageInfo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author nholvoet
 */
public interface PostService {
    
    List<? extends Post> findAll();
    
    List<? extends Post> findByPageInfo(final PageInfo pageInfo);
    
    List<? extends Post> findPostsByCategory(final String categoryId);
    
    List<? extends Post> fullTextPostSearch(final String searchValue);
    
    long getNumberOfPosts();
    
    Optional<? extends Post> findPostById(final String postId);
    
    Post addCommentToPostWithId(Comment comment, final String postId);
}
