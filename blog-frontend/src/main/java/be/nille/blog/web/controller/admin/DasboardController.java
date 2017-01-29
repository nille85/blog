/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nholvoet
 */
@Controller
public class DasboardController {

    public DasboardController(){
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/protected/dashboard")
    public String showDashboard () {

        return "admin/dashboard";
    }
    

    
}
