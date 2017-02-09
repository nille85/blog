/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.author;

import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class Name {

    private final String first;
    private final String last;

    public Name(final String first, final String last) {
        this.first = first;
        this.last = last;
    }
}
