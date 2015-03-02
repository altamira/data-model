package br.com.altamira.data.model.manufacture.bom;

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
import br.com.altamira.data.model.measurement.Variables;
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
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author alessandro.holanda
 */
@Table(name = "MN_BOM_ITEM_CMP")
@Entity(name = "manufacture.bom.Component")
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

    @JsonView(JSonViews.EntityView.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "component", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Delivery> delivery = new ArrayList<>();

    @NotNull
    @Embedded
    @JsonIgnore
    @AttributeOverride(name = "value", column = @Column(name = "DELIVERED"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "DELIVERED_UNIT"))
    private Measure delivered = new Measure();

    @NotNull
    @Embedded
    @JsonIgnore
    @AttributeOverride(name = "value", column = @Column(name = "REMAINING"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "REMAINING_UNIT"))
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
        Variables variable = new Variables();
        
        variable.put("quantity", this.quantity.getValue());
        variable.put("width", this.width.getValue());
        variable.put("height", this.height.getValue());
        variable.put("length", this.length.getValue());
        variable.put("weight", this.weight.getValue());
        
        this.material.setVariable(variable);
        
        // TODO check for null instead BigDecimal.ZERO. 
        //      Null means that the variable was not assigned. 
        //      Zero means that a number was assigned to this variable and should not calculated.
        /*if (this.width.getValue() == BigDecimal.ZERO) {
            this.width.setValue(variable.get("width"));
        }
        
        if (this.height.getValue() == BigDecimal.ZERO) {
            this.height.setValue(variable.get("height"));
        }
        
        if (this.length.getValue() == BigDecimal.ZERO) {
            this.length.setValue(variable.get("length"));
        }*/
        
        //ALTAMIRA-76: 
        //this.weight.setValue(variable.get("weight"));

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
        return item;
    }

    /**
     *
     * @param item
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

    /*public Product getProduct() {
     return product;
     }

     public void setProduct(Product product) {
     this.product = product;
     }*/
    /**
     * @return the delivery
     */
    public List<Delivery> getDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(List<Delivery> delivery) {
        this.delivery = delivery;
    }

    /**
     * @return the delivered
     */
    public Measure getDelivered() {
        return delivered;
    }

    /**
     * @param delivered the delivered to set
     */
    public void setDelivered(Measure delivered) {
        this.delivered = delivered;
    }

    /**
     * @return the remaining
     */
    public Measure getRemaining() {
        return remaining;
    }

    /**
     * @param remaining the remaining to set
     */
    public void setRemaining(Measure remaining) {
        this.remaining = remaining;
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
