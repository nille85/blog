/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.boot;

import be.nille.blog.dal.Post;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nholvoet
 */
@Controller
public class HomeController {
    
    private final Datastore dataStore;
    
    @Autowired
    public HomeController(final Datastore dataStore){
        this.dataStore = dataStore;
    }
    
    @RequestMapping("/")
    public String indexAction (ModelMap model) {
        List<Post> posts = dataStore.createQuery(Post.class).asList();
        model.put("posts", posts);
        return "index";
    }
    
}
