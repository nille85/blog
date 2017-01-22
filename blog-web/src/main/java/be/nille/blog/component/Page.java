/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component;

import spark.Request;
import spark.Response;

/**
 *
 * @author Niels Holvoet
 */
public interface Page {
    
    String handleRequest(Request request, Response response);
    
}
