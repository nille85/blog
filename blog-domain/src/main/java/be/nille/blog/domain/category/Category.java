/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.domain.category;

import lombok.Getter;

/**
 *
 * @author Niels Holvoet
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
