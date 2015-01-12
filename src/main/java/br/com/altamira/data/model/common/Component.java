/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.common;

import br.com.altamira.data.model.Relation;
import br.com.altamira.data.model.measurement.Measure;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@Table(name = "CM_COMPONENT")
@Entity(name = "common.Component")
public class Component extends Relation {

    /**
     *
     */
    private static final long serialVersionUID = 1614440376494436376L;

    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PARENT", referencedColumnName = "ID", nullable = false)
    private Material parent;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "MATERIAL", referencedColumnName = "ID", nullable = false/*, insertable = false, updatable = false*/)
    private Material material = new Material();
    
    @NotNull
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "value", column = @Column(name = "QUANTITY_VAL")), 
                        @AttributeOverride(name = "formula", column = @Column(name = "QUANTITY_FORMULA"))})
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();

    /**
     *
     */
    public Component() {
        this.parentType = br.com.altamira.data.model.common.Material.class;
    }

    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("Component requires a Material instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        this.parent = (Material) parent;
    }

    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return this.parent;
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
