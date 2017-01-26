package be.nille.blog.domain;

import lombok.Getter;

/**
 * Created by nholvoet on 26/01/2017.
 */
@Getter
public final class Category {

    private final String id;
    private final String description;

    public Category(final String id, final String description){
        this.id = id;
        this.description = description;
    }
}
