/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.dal.service;

/**
 *
 * @author Niels Holvoet
 */
public abstract class DomainEntity<K> {

    public abstract void setId(K id);

    public abstract K getId();
}
