package be.nille.blog.domain;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by nholvoet on 26/01/2017.
 */
public class AuthorTest {

    @Test
    public void emailShouldBeSetWhenAuthorIsCreated(){
        Author author = new Author("johndoe@test.com",new Author.Name("John","Doe"));
        assertEquals("johndoe@test.com", author.getEmail());
    }

    @Test
    public void nameShouldBeSetWhenAuthorIsCreated(){
        Author author = new Author("johndoe@test.com",new Author.Name("John","Doe"));
        assertNotNull(author.getName());
    }
}
