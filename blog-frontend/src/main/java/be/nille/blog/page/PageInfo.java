package be.nille.blog.page;

import lombok.Getter;

/**
 * Created by nholvoet on 27/01/2017.
 */
@Getter
public final class PageInfo {

    private final int pageNumber;
    private final int numberOfItemsInPage;
    private final long totalItems;


    public PageInfo(final long totalItems){

        this(1,10,totalItems);
    }

    public PageInfo(final int pageNumber, final int numberOfItemsInPage, final long totalItems){
        this.pageNumber = pageNumber;
        this. numberOfItemsInPage = numberOfItemsInPage;
        this.totalItems = totalItems;
    }


    public int getNumberOfPages(){
        return (int) Math.ceil(totalItems /  (float) numberOfItemsInPage);
    }


    public boolean hasNext(){
        return pageNumber < getNumberOfPages();
    }

    public boolean hasPrevious(){
        return pageNumber > 1;
    }

    public PageInfo next(){
        if(hasNext()){
            return new PageInfo(pageNumber + 1, this. numberOfItemsInPage, this.totalItems);
        }
        return this;
    }

    public PageInfo previous(){
        if(hasPrevious()){
            return new PageInfo(pageNumber - 1, this. numberOfItemsInPage, this.totalItems);
        }
        return this;
    }
}
