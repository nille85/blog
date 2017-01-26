package be.nille.blog.domain;

import lombok.Getter;

/**
 * Created by nholvoet on 26/01/2017.
 */
@Getter
public final class Author {

    private final String email;
    private final Name name;

    Author(final String email, final Name name){
        this.email = email;
        this.name = name;
    }



    @Getter
    public static class Name{

        private final String first;
        private final String last;


        public Name(final String first, final String last){
            this.first = first;
            this.last = last;
        }
    }


}
