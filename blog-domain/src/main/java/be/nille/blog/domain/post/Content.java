/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.post;

import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@ToString
public class Content{

    private final String title;
    private final String text;

    public Content(final String title, final String text) {
        this.title = title;
        this.text = text;
    }
}
