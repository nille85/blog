package be.nille.blog.page;

import be.nille.blog.web.page.PageInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nholvoet on 27/01/2017.
 */
public class PageInfoTest {

    @Test
    public void shouldBeCreated(){
        PageInfo pageInfo = new PageInfo(3,10,157);
        assertEquals(3 , pageInfo.getPageNumber());
        assertEquals(10, pageInfo.getNumberOfItemsInPage());
        assertEquals(157, pageInfo.getTotalItems());
    }

    @Test
    public void shouldNotHavePreviousWhenPageNumberIs0(){
        PageInfo pageInfo = new PageInfo(0,10,157);
        assertFalse(pageInfo.hasPrevious());
    }

    @Test
    public void shouldHave16PagesWhenTotalItemsIs157AndNumberOfItemsInPageIs10(){
        PageInfo pageInfo = new PageInfo(1,10,157);
        assertTrue(pageInfo.getNumberOfPages() == 16);
    }

    @Test
    public void shouldNotHaveNextWhenPageNumberIs16AndTotalItemsIs157AndNumberOfItemsInPageIs10(){
        PageInfo pageInfo = new PageInfo(16,10,157);
        assertFalse(pageInfo.hasNext());
    }



}
