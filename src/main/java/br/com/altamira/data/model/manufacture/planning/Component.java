package br.com.altamira.data.model.manufacture.planning;

import br.com.altamira.data.model.Resource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.common.Color;
import br.com.altamira.data.model.measurement.Measure;
import br.com.altamira.data.model.serialize.JSonViews;
import br.com.altamira.data.model.serialize.NullCollectionSerializer;
import br.com.altamira.data.model.serialize.NullObjectSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author alessandro.holanda
 */
@Table(name = "MN_BOM_ITEM_CMP")
@Entity(name = "br.com.altamira.data.model.manufacture.planning.Component")
public class Component extends Resource {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = -4871377387938455032L;

    @JsonIgnore
    @JoinColumn(name = "ITEM", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;

    @JsonIgnore
    @JoinColumn(name = "MATERIAL", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    private Material material;
    
    @NotNull
    @Size(min = 3)
    @Column(name = "CODE", unique = true, nullable = false)
    private String code = "";

    @NotNull
    @Size(min = 5)
    @Column(name = "DESCRIPTION", unique = true, nullable = false)
    private String description = "";
    
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
    @AttributeOverride(name = "value", column = @Column(name = "WEIGHT"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WEIGHT_UNIT"))
    private Measure weight = new Measure();
    
    @JsonIgnore
    @JsonView(JSonViews.EntityView.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="COMPONENT", insertable=false, updatable=false)
    private List<Produce> produce = new ArrayList<>();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "PRODUCE"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "PRODUCE_UNIT"))
    private Measure produced = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "PRODUCE_REMAINING"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "PRODUCE_REMAINING_UNIT"))
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
    @JsonIgnore
    public Material getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    @JsonIgnore
    public void setMaterial(Material material) {
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
    @JsonIgnore
    public List<Produce> getProduce() {
        return produce;
    }

    /**
     * @param produce
     */
    @JsonIgnore
    public void setProduce(List<Produce> produce) {
        this.produce = produce;
    }
    
    /**
     * @return the remaining
     */
    
    public Measure getProduced() {
        return produced;
    }
    
    /**
     * @return the remaining
     */
    public Measure getRemaining() {
    	this.remaining.setValue(this.quantity.getValue().subtract(this.produced.getValue()));
    	this.remaining.setUnit(this.quantity.getUnit());
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
    public void setProduced(Measure produced) {
        this.produced = produced;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
