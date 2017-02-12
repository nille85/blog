/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.web.page;

import be.nille.blog.web.page.component.HTMLComponent;
import be.nille.blog.domain.category.CategoryService;
import be.nille.blog.domain.post.PostService;
import be.nille.blog.service.PageInfo;
import be.nille.blog.web.controller.post.PostsPage;
import javax.servlet.http.HttpServletResponse;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Niels Holvoet
 */
@Controller
public class HTMLController {
    
    private final StaticContentPage staticContentPage;
  
    @Autowired
    public HTMLController(final StaticContentPage staticContentPage){
        this.staticContentPage = staticContentPage;
        
    }

    @RequestMapping(method = RequestMethod.GET, value = "/html", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String htmlAction(HttpServletResponse response) {
       
        String html = staticContentPage.render();  
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        return html;
    }
    
    /*
    @RequestMapping("/placeholder")
    public String placeholderAction (ModelMap model) {
       
        TwoColumnPage page = new TwoColumnPage(categoryService.findAll());
        
        
        model.put("leftColumn", page.getLeftColumn().render());
        model.put("rightColumn",page.getRightColumn().render());
        return "widgets/page";
    }
    */

}
