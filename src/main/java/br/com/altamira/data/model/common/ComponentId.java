/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.common;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alessandro
 */
@Embeddable
public class ComponentId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Material parent;
 
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Material material;  

    /**
     * @return the parent
     */
    public Material getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Material parent) {
        this.parent = parent;
    }

    /**
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }
    
}
