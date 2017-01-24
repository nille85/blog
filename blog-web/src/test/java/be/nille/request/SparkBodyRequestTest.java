/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.request;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author nholvoet
 */
public class SparkBodyRequestTest {
    
    @Getter
    @Setter
    public static class Person{
        private String id;
        private String name;
        private String street;
        
    }
    
 
    
   
    private SparkRequestBody<Person> spRequest;
    
    private ServletRequest servletRequest;
    
    @Before
    public void setup(){
        servletRequest = Mockito.mock(ServletRequest.class);
        spRequest = new SparkRequestBody<>(servletRequest);
    }
    
    @Test
    public void populate(){
        Map<String,String[]> map = new HashMap<>();
        map.put("id", new String[]{"1"});
        map.put("name", new String[]{"john doe"});
        map.put("street", new String[]{"Grote Markt"});
        when(servletRequest.getParameterMap()).thenReturn(map);
        Person person = spRequest.populateObject(new Person());
        assertEquals("1", person.getId());
        assertEquals("john doe", person.getName());
        assertEquals("Grote Markt", person.getStreet());
    }
    
}
