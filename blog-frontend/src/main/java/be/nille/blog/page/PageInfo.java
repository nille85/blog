package be.nille.blog.page;

import lombok.Getter;

/**
 * Created by nholvoet on 27/01/2017.
 */
@Getter
public final class PageInfo {

    private final int pageNumber;
    private final int numberOfPostsInPage;
    private final long totalItems;

    public PageInfo(final int pageNumber, final int numberOfPostsInPage, final long totalItems){
        this.pageNumber = pageNumber;
        this.numberOfPostsInPage = numberOfPostsInPage;
        this.totalItems = totalItems;
    }


    public int getNumberOfPages(){
        return (int) Math.ceil(totalItems / numberOfPostsInPage);
    }


    public boolean hasNext(){
        return pageNumber < getNumberOfPages();
    }

    public boolean hasPrevious(){
        return pageNumber > 0;
    }

    public PageInfo next(){
        if(hasNext()){
            return new PageInfo(pageNumber + 1, this.numberOfPostsInPage, this.totalItems);
        }
        return this;
    }

    public PageInfo previous(){
        if(hasPrevious()){
            return new PageInfo(pageNumber - 1, this.numberOfPostsInPage, this.totalItems);
        }
        return this;
    }
}
