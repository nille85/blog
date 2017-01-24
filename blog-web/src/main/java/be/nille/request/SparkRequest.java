/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.request;

/**
 *
 * @author nholvoet
 */
public interface SparkRequest<T> {
    
    
    T populateObject(T object);
    
}
