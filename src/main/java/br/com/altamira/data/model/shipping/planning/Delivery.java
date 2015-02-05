package br.com.altamira.data.model.shipping.planning;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * Represents a sales order item
 */
@Entity(name = "shipping.planning.Delivery")
@Table(name = "MN_BOM_ITEM_CMP_SH", uniqueConstraints = @UniqueConstraint(columnNames = {"COMPONENT", "DELIVERY"}))
public class Delivery extends Document implements Comparable<Delivery> {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = 7448803904699786256L;

    @JsonIgnore
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    @JoinColumn(name = "COMPONENT", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Component component;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "DELIVERY")
    private Date delivery = new Date();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "DELIVERED"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "DELIVERED_UNIT"))
    private Measure delivered = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "REMAINING"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "REMAINING_UNIT"))
    private Measure remaining = new Measure();

    /**
     *
     */
    public Delivery() {
        this.parentType = Component.class;
    }

    /**
     *
     * @param component
     * @param delivery
     * @param quantity
     */
    public Delivery(Component component, Date delivery, Measure quantity) {
        this.parentType = Component.class;
        this.component = component;
        this.delivery = delivery;
        this.quantity = quantity;
    }

    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("Shipping requires a Component instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        setComponent((Component) parent);
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
    @JsonIgnore
    public Component getComponent() {
        return component;
    }

    /**
     * @param component the component to set
     */
    @JsonIgnore
    public void setComponent(Component component) {
        this.component = component;
    }

    /**
     * @return the delivery
     */
    public Date getDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(Date delivery) {
        this.delivery = delivery;
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
     * @return the remaining
     */
    public Measure getDelivered() {
        return delivered;
    }

    /**
     * @return the remaining
     */
    public Measure getRemaining() {
    	this.remaining.setValue(this.quantity.getValue().subtract(this.delivered.getValue())); 	
    	this.remaining.setUnit(this.component.getQuantity().getUnit());
        return remaining;
    }

    /**
     * @param remaining the remaining to set
     */
    public void setRemaining(Measure remaining) {
        this.remaining = remaining;
    }

    /**
     * @param delivered the delivered to set
     */
    public void setDelivered(Measure delivered) {
        this.delivered = delivered;
    }

    @Override
    public int compareTo(Delivery delivery) {
        return this.delivery.compareTo(delivery.getDelivery());
    }
}
