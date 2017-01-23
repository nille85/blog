/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component.home;

import be.nille.blog.component.Page;
import be.nille.blog.component.Template;
import be.nille.blog.dal.Post;
import be.nille.blog.dal.mongo.MgPosts;
import be.nille.blog.dal.mongo.MongoRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import spark.Request;
import spark.Response;

/**
 *
 * @author Niels Holvoet
 */
public class HomePage implements Page {

    private final MongoDatabase database;
    
    public HomePage(MongoDatabase database) {
        this.database = database;
    }

    @Override
    public String handleRequest(Request request, Response response) {
        MongoCollection<Document> collection = database.getCollection("posts");
        MongoRepository<Post> posts = new MgPosts(collection);

        Template template = new HomeTemplate(posts.findAll());
        return template.render();
    }

}
