/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.service.mongo;

import lombok.Getter;


/**
 *
 * @author Niels Holvoet
 */
@Getter
public abstract class MongoMapper<D, M> {

    
    protected abstract D createDomainObject(M mongoObject);
    
    public abstract M createMongoObject(D domainObject);

}
