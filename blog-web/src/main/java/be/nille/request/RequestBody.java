/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.request;

import java.util.Optional;

/**
 *
 * @author nholvoet
 */
public interface RequestBody {
    
    Optional<String> getFirstValueOf(final String key);
    
    Optional<String[]> getAllValuesOf(final String key);
    
}
