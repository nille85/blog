/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.jtwig;



import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class JtwigTest {

    @Test
    public void testTemplate() throws IOException {
   
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/example.twig");
        JtwigModel model = JtwigModel.newModel().with("var", "World");
        String output = template.render(model);
        assertEquals("Hello World", output);
    }
    
     
    
   

}
