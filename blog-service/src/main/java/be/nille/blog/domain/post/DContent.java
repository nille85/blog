/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.post;

import be.nille.blog.service.Post;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@ToString
public class DContent implements Post.Content {

    private final String title;
    private final String text;

    public DContent(final String title, final String text) {
        this.title = title;
        this.text = text;
    }
}
