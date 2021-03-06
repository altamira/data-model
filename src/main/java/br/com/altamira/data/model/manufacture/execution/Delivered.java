package br.com.altamira.data.model.manufacture.execution;

import br.com.altamira.data.model.manufacture.Operation;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.common.Document;
import br.com.altamira.data.model.measurement.Measure;
import br.com.altamira.data.model.serialize.NullObjectSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * Represents a sales order item
 */
@Entity(name = "br.com.altamira.data.model.manufacture.execution.Delivered")
@Table(name = "MN_EXECUTION")
public class Delivered extends Document {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = 7448803904699786256L;

    @NotNull
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    @JoinColumn(name = "OPERATION", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Operation operation;
    
    @NotNull
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    @JoinColumn(name = "COMPONENT", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Component component;
    
    @NotNull
    @Temporal(value = TemporalType.DATE)
    @Column(name = "DELIVERED")
    private Date delivered = new Date();
    
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();
    
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "WEIGHT"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WEIGHT_UNIT"))
    private Measure weight = new Measure("kg");
    
    /**
     *
     */
    public Delivered() {
        this.parentType = Component.class;
    }
    
    /**
     *
     * @param component
     * @param delivered
     * @param quantity
     */
    public Delivered(Component component, Date delivered, Measure quantity) {
        this.parentType = Component.class;
        this.component = component;
        this.delivered = delivered;
        this.quantity = quantity;
    }
        
    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("Execution requires a Component instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }
     
        setComponent((Component)parent);
    }
    
    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getComponent();
    }

    /**
     * @return the component
     */
    public Component getComponent() {
        return component;
    }

    /**
     * @param component the component to set
     */
    public void setComponent(Component component) {
        this.component = component;
    }

    /**
     * @return the delivery
     */
    public Date getDelivery() {
        return delivered;
    }

    /**
     * @param delivered the delivery to set
     */
    public void setDelivery(Date delivered) {
        this.delivered = delivered;
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
     * @return the operation
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * @return the weight
     */
    public Measure getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Measure weight) {
        this.weight = weight;
    }

}
