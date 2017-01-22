/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component.home;

import be.nille.blog.component.Page;
import be.nille.blog.component.Template;
import be.nille.blog.dal.Posts;
import be.nille.blog.dal.mongo.MgPosts;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
public class HomePage implements Page {

    private final MongoDatabase database;
    
    public HomePage(MongoDatabase database) {
        this.database = database;
    }

    public String handleRequest() {
        MongoCollection<Document> collection = database.getCollection("posts");
        Posts posts = new MgPosts(collection);

        Template template = new HomeTemplate(posts.findAll());
        return template.render();
    }

}
