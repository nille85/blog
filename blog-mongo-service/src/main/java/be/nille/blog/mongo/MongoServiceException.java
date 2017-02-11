/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.mongo;

/**
 *
 * @author Niels Holvoet
 */
public class MongoServiceException extends RuntimeException{
    
     public MongoServiceException(final String message){
        super(message);
    }
    
    public MongoServiceException(final String message, final Throwable throwable){
        super(message, throwable);
    }
    
}
