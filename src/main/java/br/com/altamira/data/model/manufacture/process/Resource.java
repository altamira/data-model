/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.process;

import br.com.altamira.data.model.measurement.Formula;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@javax.persistence.MappedSuperclass
public abstract class Resource extends br.com.altamira.data.model.Relation {
    /**
     *
     */
    private static final long serialVersionUID = -492716374383567653L;

    @JsonIgnore
    @JoinColumn(name = "OPERATION", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Operation operation = new Operation();

    @JoinColumn(name = "MATERIAL", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private br.com.altamira.data.model.common.Material material = new br.com.altamira.data.model.common.Material();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Formula quantity = new Formula();

    /**
     *
     */
    public Resource() {
        this.parentType = Operation.class;
    }

    /**
     *
     * @return
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     *
     * @param operation
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * @return the material
     */
    public br.com.altamira.data.model.common.Material getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(br.com.altamira.data.model.common.Material material) {
        this.material = material;
    }

    /**
     * @return the quantity
     */
    public Formula getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Formula quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException(this.getClass().getName() + " requires a Operation instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        setOperation((Operation) parent);
    }

    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getOperation();
    }
    
}
