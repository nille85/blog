/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.boot;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nholvoet
 */
@Controller
public class AuthenticationController {

    public AuthenticationController(){
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/admin/login")
    public String showLogin () {

        return "admin/login";
    }
    

    
}
