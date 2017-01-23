/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.request;

import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import spark.Request;

/**
 *
 * @author nholvoet
 */
public class RequestBodyImpl implements RequestBody {
    
    private final HttpServletRequest servletRequest;
    
    
    public RequestBodyImpl(final Request request){
        this(request.raw());
    }
    
    public RequestBodyImpl(final HttpServletRequest servletRequest){
        this.servletRequest = servletRequest;
    }
    
    @Override
    public Optional<String> getFirstValueOf(final String key){
         Map<String,String[]> map =  servletRequest.getParameterMap();
         if(map.containsKey(key)){
             String[] values = map.get(key);
             if(values.length > 0){
                 return Optional.of(values[0]);
             }
         }
         return Optional.empty();
    }
    
    @Override
    public Optional<String[]> getAllValuesOf(final String key){
         Map<String,String[]> map =  servletRequest.getParameterMap();
         if(map.containsKey(key)){
             String[] values = map.get(key);
                 return Optional.of(values);
         }
         return Optional.empty();
    }
    
}
