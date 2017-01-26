package be.nille.blog.domain;

import lombok.Getter;

/**
 * Created by nholvoet on 26/01/2017.
 */
@Getter
public final class Category {

    private final String title;

    Category(final String title){
        this.title = title;
    }
}
