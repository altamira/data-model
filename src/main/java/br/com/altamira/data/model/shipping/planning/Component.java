package br.com.altamira.data.model.shipping.planning;

import br.com.altamira.data.model.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.common.Color;
import br.com.altamira.data.model.common.Material;
import br.com.altamira.data.model.measurement.Measure;
import br.com.altamira.data.model.serialize.NullCollectionSerializer;
import br.com.altamira.data.model.serialize.NullObjectSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author alessandro.holanda
 */
@Table(name = "MN_BOM_ITEM_CMP")
@Entity(name = "shipping.planning.Component")
public class Component extends Resource {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = -4871377387938455032L;

    @JsonIgnore
    @JoinColumn(name = "ITEM", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;

    @NotNull
    @JoinColumn(name = "MATERIAL", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    private Material material;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "COLOR", referencedColumnName = "ID", nullable = false /*, insertable = false, updatable = false, unique = false*/)
    private Color color = new Color();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "WIDTH"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WIDTH_UNIT"))
    private Measure width = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "HEIGHT"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "HEIGHT_UNIT"))
    private Measure height = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "LENGTH"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "LENGTH_UNIT"))
    private Measure length = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "WEIGHT"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WEIGHT_UNIT"))
    private Measure weight = new Measure();
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="COMPONENT", insertable=false, updatable=false)
    private Set<Delivery> delivery = new HashSet<>();

    @Transient
    @JsonInclude
    private Measure delivered = new Measure();
    
    @Transient
    @JsonInclude
    private Measure remaining = new Measure();
    
    /**
     *
     */
    public Component() {
        this.parentType = Item.class;
    }

    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("Component requires a Item instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        setItem((Item) parent);
    }

    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getItem();
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
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    @JsonIgnore
    public Item getItem() {
        return this.item;
    }

    /**
     *
     * @param item
     * 
     * 
     */
    @JsonIgnore
    public void setItem(Item item) {
        this.item = item;
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
     * @return the width
     */
    public Measure getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(Measure width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public Measure getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Measure height) {
        this.height = height;
    }

    /**
     * @return the length
     */
    public Measure getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(Measure length) {
        this.length = length;
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

    /**
     * @return the delivery
     */
    public Set<Delivery> getDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(Set<Delivery> delivery) {
        this.delivery = delivery;
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
        return remaining;
    }
}
