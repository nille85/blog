/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
public class DPostTest {
    
    @Test
    public void titleShouldBeCorrect(){
        Post post = new DPost("title", "the lead");
        assertEquals("title", post.getTitle());
    }
    
    @Test
    public void leadShouldBeCorrect(){
        Post post = new DPost("title", "the lead");
        assertEquals("the lead", post.getLead());
    }
    
}
