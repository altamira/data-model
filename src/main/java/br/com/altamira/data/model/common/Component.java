/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.common;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.measurement.Measure;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "CM_COMPONENT")
public class Component extends Resource {

    @EmbeddedId
    private ComponentId relation = new ComponentId();
    
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT", referencedColumnName = "ID", updatable = false, insertable = false)
    private Material parent = new Material();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIAL", referencedColumnName = "ID", updatable = false, insertable = false)
    private Material material = new Material();

    /*@JsonView(JSonViews.EntityView.class)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "component", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Material> material;*/
        
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();

    public Component() {
        this.parentType = br.com.altamira.data.model.common.Material.class;
    }

    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("Component requires a Material instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        this.parent = ((br.com.altamira.data.model.common.Material) parent);
    }

    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return this.parent;
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

    /**
     * @return the quantity
     */
    public Measure getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Measure quantity) {
        this.quantity = quantity;
    }

    
    
}
