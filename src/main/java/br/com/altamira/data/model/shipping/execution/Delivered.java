package br.com.altamira.data.model.shipping.execution;

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
@Entity(name = "shipping.execution.Delivered")
@Table(name = "SH_DELIVERED", uniqueConstraints = @UniqueConstraint(columnNames = {"PACKINGLIST", "COMPONENT", "DELIVERED"}))
public class Delivered extends Document {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = 7448803904699786256L;

    @JsonIgnore
    @JoinColumn(name = "PACKINGLIST", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PackingList packingList;
        
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
    /**
     *
     */
    public Delivered() {
        this.parentType = PackingList.class;
    }
    
    /**
     *
     * @param packingList
     * @param component
     * @param delivered
     * @param quantity
     */
    public Delivered(PackingList packingList, Component component, Date delivered, Measure quantity) {
        this.parentType = PackingList.class;
        this.packingList = packingList;
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
            throw new IllegalArgumentException("Shipping requires a Component instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }
     
        setPackingList((PackingList)parent);
    }
    
    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getPackingList();
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
     * @return the packingList
     */
    @JsonIgnore
    public PackingList getPackingList() {
        return packingList;
    }

    /**
     * @param packingList the packingList to set
     */
    @JsonIgnore
    public void setPackingList(PackingList packingList) {
        this.packingList = packingList;
    }

}
