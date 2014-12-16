package br.com.altamira.data.model.manufacture.bom;

import br.com.altamira.data.model.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.altamira.data.model.common.Color;
import br.com.altamira.data.model.common.Material;
import br.com.altamira.data.model.measurement.Measure;
import br.com.altamira.data.model.serialize.NullObjectSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Embedded;

/**
 *
 * @author alessandro.holanda
 */
@Entity
@Table(name = "MN_BOM_ITEM_PART")
public class BOMItemPart extends Resource {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = -4871377387938455032L;

    @JsonIgnore
    @JoinColumn(name = "ORDER_ITEM", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BOMItem bomItem;

    @NotNull
    @Size(min = 3)
    @Column(name = "CODE")
    private String code = "";

    @NotNull
    @Size(min = 5)
    @Column(name = "DESCRIPTION")
    private String description = "";

    @JoinColumn(name = "MATERIAL")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    private Material material;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "COLOR", referencedColumnName = "ID", nullable = false /*, insertable = false, updatable = false, unique = false*/)
    private Color color = new Color();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "WIDTH_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WIDTH_UNIT"))
    private Measure width = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "HEIGHT_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "HEIGHT_UNIT"))
    private Measure height = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "LENGTH_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "LENGTH_UNIT"))
    private Measure length = new Measure();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "WEIGHT_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WEIGHT_UNIT"))
    private Measure weight = new Measure();

    /**
     *
     */
    public BOMItemPart() {
        this.parentType = BOMItem.class;
    }

    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("BOMItemPart requires a BOMItem instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        setBOMItem((BOMItem) parent);
    }

    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getBOMItem();
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
    public BOMItem getBOMItem() {
        return getBOMItem();
    }

    /**
     *
     * @param bomItem
     */
    @JsonIgnore
    public void setBOMItem(BOMItem bomItem) {
        this.bomItem = bomItem;
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
}
