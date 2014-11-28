/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.common;

import br.com.altamira.data.model.Relation;
import br.com.altamira.data.model.measurement.Measure;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
public class Component extends Relation {

    @ManyToOne
    @JoinColumn(name = "PARENT", referencedColumnName = "ID", insertable = false, updatable = false)
    private Material parent;

    @ManyToOne
    @JoinColumn(name = "MATERIAL", referencedColumnName = "ID", insertable = false, updatable = false)
    private Material material;

    /*@JsonIgnore
     @JoinColumn(name = "MATERIAL", referencedColumnName = "ID")
     @ManyToOne(optional = false, fetch = FetchType.LAZY)
     private Material material = new Material();*/

    /*@JsonView(JSonViews.EntityView.class)
     @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "component", fetch = FetchType.LAZY, orphanRemoval = false)
     private List<Material> component = new ArrayList<>();*/
    /*@ManyToOne(optional = false, fetch = FetchType.LAZY)
     @JoinColumn(name = "MATERIAL", referencedColumnName = "ID", updatable = false, insertable = false)
     private Material material = new Material();*/
    
    
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();
    
    public Component() {
        this.parentType = br.com.altamira.data.model.common.Material.class;
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
