/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.service;


import java.util.List;
import java.util.Optional;

/**
 *
 * @author nholvoet
 */
public interface PostService {
    
    List<? extends Post> findAll();
    
    List<? extends Post> findByOffsetAndLimit(final PageInfo pageInfo);
    
    List<? extends Post> findPostsByCategory(final String categoryId);
    
    long getNumberOfPosts();
    
    Optional<? extends Post> findPostById(final String postId);
    
    Post addCommentToPostWithId(Post.Comment comment, final String postId);
}
