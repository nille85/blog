/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.request;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.servlet.ServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import spark.Request;

/**
 *
 * @author nholvoet
 */
@Slf4j
public class SparkRequestBody<T> implements SparkRequest<T>   {
    
    private final ServletRequest servletRequest;
    
    public SparkRequestBody(final Request request){
        this(request.raw());
    }
    
    public SparkRequestBody(final ServletRequest servletRequest){
        this.servletRequest = servletRequest;
    }
    

    @Override
    public T populateObject(T object) {
        try{
            BeanUtils.populate(object, servletRequest.getParameterMap());
            return object;
        }catch(IllegalAccessException | InvocationTargetException ex){
            throw new RuntimeException(
                    String.format("Could not populate object of type %s",object.getClass()),
                    ex
            );
        }
    }


    
    
}
