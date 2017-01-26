package be.nille.blog.domain;

import lombok.Getter;

/**
 * Created by nholvoet on 26/01/2017.
 */
@Getter
public final class Comment {


    private final String name;
    private final String text;

    public Comment(final String name, final String text){
        this.name = name;
        this.text = text;
    }
}
