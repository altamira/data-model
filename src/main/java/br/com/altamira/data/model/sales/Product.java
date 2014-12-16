package br.com.altamira.data.model.sales;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.common.Material;
import br.com.altamira.data.model.measurement.Measure;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;

/**
 *
 * @author alessandro.holanda
 */
@Entity(name = "sales.Product")
@Table(name = "SL_PRODUCT")
public class Product extends Material {

    /**
     *
     */
    private static final long serialVersionUID = -4871377387938455032L;
    
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
    
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "DEPTH_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "DEPTH_UNIT"))
    private Measure depth = new Measure(); 

    /**
     *
     */
    public Product() {
        
    }

    /**
     *
     * @param id
     * @param code
     * @param description
     */
    public Product(long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    /**
     *
     * @param id
     * @param code
     * @param description
     * @param type
     */
    public Product(long id, String code, String description, String type) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.setType(type);
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
     * @return the depth
     */
    public Measure getDepth() {
        return depth;
    }

    /**
     * @param depth the depth to set
     */
    public void setDepth(Measure depth) {
        this.depth = depth;
    }
    
}
