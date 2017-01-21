/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.ci;

import be.nille.blog.component.Page;
import be.nille.blog.component.navigation.Blog;
import be.nille.blog.component.navigation.IndexTemplate;
import spark.Request;
import spark.Response;

/**
 *
 * @author Niels Holvoet
 */
public class IndexPage implements Page {
    
    private final IndexTemplate template;
    
    public IndexPage(final Blog blog){
        this.template = new IndexTemplate(blog);
    }
    
    public IndexPage(final IndexTemplate template){
        this.template = template;
    }
    
    @Override
    public String handleRequest(final Request request, final Response response){
        return template.render();
    }
    
}
