package br.com.altamira.data.model.manufacture.planning;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.measurement.Measure;
import br.com.altamira.data.model.serialize.NullObjectSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity(name = "br.com.altamira.data.model.manufacture.planning.Produce")
@Table(name = "MN_ORDER_ITEM_CMP")
public class Produce extends Resource {

    /**
     *
     */
    private static final long serialVersionUID = -96266958106783345L;

    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    @JoinColumn(name = "MN_ORDER", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Order order;

    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    @JoinColumn(name = "COMPONENT", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Component component;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "PRODUCED"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "PRODUCED_UNIT"))
    private Measure produced = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "REMAINING"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "REMAINING_UNIT"))
    private Measure remaining = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "WEIGHT"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WEIGHT_UNIT"))
    private Measure weight = new Measure();
    
    /**
     *
     */
    public Produce() {
        this.parentType = Order.class;
    }

    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("Produce requires a Item instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        setOrder((Order) parent);
    }

    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getOrder();
    }
    
    /**
     *
     * @return
     */
    public Order getOrder() {
        return order;
    }

    /**
     *
     * @param order
     */
    //@JsonIgnore
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     *
     * @return
     */
    public Component getComponent() {
        return component;
    }

    /**
     *
     * @param component
     */
    public void setComponent(Component component) {
        this.component = component;
    }

    /**
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public Measure getProduced() {
        return produced;
    }

    /**
     *
     * @param produced
     */
    public void setProduced(Measure produced) {
        this.produced = produced;
    }

    /**
     *
     * @return
     */
    public Measure getRemaining() {
        return remaining;
    }

    /**
     *
     * @param remaining
     */
    public void setRemaining(Measure remaining) {
        this.remaining = remaining;
    }

    /**
     *
     * @return
     */
    public Measure getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(Measure quantity) {
        this.quantity = quantity;
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
