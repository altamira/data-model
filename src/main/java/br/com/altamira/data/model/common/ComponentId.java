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
    private Material material;
 
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Material component;  

    /**
     * @return the parent
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @param material
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * @return the material
     */
    public Material getComponent() {
        return this.component;
    }

    /**
     * @param material the material to set
     */
    public void setComponent(Material material) {
        this.component = material;
    }
    
}
