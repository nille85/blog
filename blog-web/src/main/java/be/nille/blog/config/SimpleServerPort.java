/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.config;

import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class SimpleServerPort implements ServerPort {
    
    private final int value;
    
    public SimpleServerPort(){
        this(8080);
    }
   
    public SimpleServerPort(final String portNumberAsString){
        if(portNumberAsString != null){
            this.value = Integer.valueOf(portNumberAsString);
        }else{
            this.value = 8080;
        }
    }
    
    public SimpleServerPort(final int portNumber){
        this.value = portNumber;
    }
}
