/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.service.mongo;

import be.nille.blog.dal.mongo.morphia.model.MgCategory;
import be.nille.blog.dal.service.DomainEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;

/**
 *
 * @author Niels Holvoet
 * @param <M> type of mongo class
 * @param <D> type of domain class
 */
public abstract class MgRepository<D extends DomainEntity,M> {

    private final Datastore datastore;
    private final MongoMapper<D,M> mapper;
    private final Class<M> mongoType;

    public MgRepository(final Datastore datastore, final Class<M> mongoType, final MongoMapper<D,M> mapper ) {
        this.datastore = datastore;
        this.mapper = mapper;
        this.mongoType = mongoType;
    }

    
    public D add(D domainObject) {
        D copy = domainObject;
        M mongoObject = mapper.createMongoObject(domainObject);
        Key<M> key = datastore.save(mongoObject);
        copy.setId(key.getId());
        return copy;
    }

   
    public void remove(D domainObject) {
        D copy = domainObject;
        datastore.delete(MgCategory.class, copy.getId());
    }

  
    public List<D> findAll() {

         List<M> mongoObjects = (List<M>) datastore.find(mongoType.getClass()).asList();
         return mongoObjects.stream()
                 .map(m -> mapper.createDomainObject(m))
                 .collect(Collectors.toList());          
    }
    
    
    public D findOne(String key) {
        M mongoObject = (M) datastore.get(mongoType.getClass(), key);
        return mapper.createDomainObject(mongoObject);
    }

    protected Datastore getDatastore() {
        return datastore;
    }
    
    

}
