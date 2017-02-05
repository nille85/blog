/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.controller;

import be.nille.blog.service.Post;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public interface PostsPage {
    
    List<? extends Post> getPosts();
}
