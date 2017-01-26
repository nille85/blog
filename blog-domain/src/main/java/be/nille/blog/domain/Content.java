package be.nille.blog.domain;

import lombok.Getter;

/**
 * Created by nholvoet on 26/01/2017.
 */
@Getter
public class Content {

    private final String title;
    private final String text;


    public Content(final String title, final String text){
        this.title = title;
        this.text = text;
    }
}
