/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.ci;

import static org.junit.Assert.assertEquals;
import org.junit.Test;



/**
 *
 * @author Niels Holvoet
 */
public class ServerPortTest {
    
    @Test
    public void testDefault(){
        ServerPort sp = new SimpleServerPort();
        assertEquals(8080, sp.getValue());
    }
    
}
