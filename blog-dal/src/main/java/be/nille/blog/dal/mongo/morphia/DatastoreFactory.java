/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.mongo.morphia;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Niels Holvoet
 */
public class DatastoreFactory {
    
    private final Morphia morphia;
    
    public DatastoreFactory(){
        this(new Morphia());
    }
    
    public DatastoreFactory(final Morphia morphia){
        this.morphia = morphia;
    }
    
    public Datastore createDataStore(final MongoClient mongoClient,final String dbName){
        morphia.mapPackage("be.nille.blog.dal.morphia");
        final Datastore datastore = morphia.createDatastore(mongoClient,dbName);
        datastore.ensureIndexes();
        return datastore;
    }
    
}
