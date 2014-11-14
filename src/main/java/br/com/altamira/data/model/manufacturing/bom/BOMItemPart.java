package br.com.altamira.data.model.manufacturing.bom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.measurement.Measure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
    @Size(min = 10)
    @Column(name = "CODE")
    private String code = "";

    @NotNull
    @Size(min = 10)
    @Column(name = "DESCRIPTION")
    private String description = "";

    @Column(name = "COLOR")
    private String color = "";

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

    /*
     @Column(name = "QUANTITY")
     private BigDecimal quantity = BigDecimal.valueOf(0);

     @Column(name = "WIDTH")
     private BigDecimal width = BigDecimal.valueOf(0);

     @Column(name = "HEIGHT")
     private BigDecimal height = BigDecimal.valueOf(0);

     @Column(name = "LENGTH")
     private BigDecimal length = BigDecimal.valueOf(0);

     @Column(name = "WEIGHT")
     private BigDecimal weight = BigDecimal.valueOf(0);
     */

    /*
     @JoinColumn(name = "CODE", referencedColumnName = "CODE", insertable=false, updatable=false)
     @JoinColumn(name = "PRODUCT", referencedColumnName = "ID", insertable = false, updatable = false)
     @ManyToOne(optional = false, fetch = FetchType.LAZY)
     private Product product;
     */
    public BOMItemPart() {
        this.parentType = BOMItem.class;
    }

    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("BOMItemPart requires a BOMItem instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        setBOMItem((BOMItem) parent);
    }

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
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
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
    /**
     * @return the quantity
     */
    /*public BigDecimal getQuantity() {
     return quantity;
     }*/
    /**
     * @param quantity the quantity to set
     */
    /*public void setQuantity(BigDecimal quantity) {
     this.quantity = quantity;
     }*/
    /**
     * @return the width
     */
    /*public BigDecimal getWidth() {
     return width;
     }*/
    /**
     * @param width the width to set
     */
    /*public void setWidth(BigDecimal width) {
     this.width = width;
     }*/
    /**
     * @return the height
     */
    /*public BigDecimal getHeight() {
     return height;
     }*/
    /**
     * @param height the height to set
     */
    /*public void setHeight(BigDecimal height) {
     this.height = height;
     }*/
    /**
     * @return the length
     */
    /*public BigDecimal getLength() {
     return length;
     }*/
    /**
     * @param length the length to set
     */
    /*public void setLength(BigDecimal length) {
     this.length = length;
     }*/
    /**
     * @return the weight
     */
    /*public Measure getWeight() {
     return weight;
     }*/
    /**
     * @param weight the weight to set
     */
    /*public void setWeight(Measure weight) {
     this.weight = weight;
     }*/
}
