package br.com.altamira.data.model.sales;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.common.Material;
import br.com.altamira.data.model.measurement.Formula;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
    @AttributeOverrides({@AttributeOverride(name = "value", column = @Column(name = "WIDTH_VAL")), 
                        @AttributeOverride(name = "formula", column = @Column(name = "WIDTH_FORMULA"))})
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WIDTH_UNIT"))
    private Formula width = new Formula();
    
    @NotNull
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "value", column = @Column(name = "HEIGHT_VAL")), 
                        @AttributeOverride(name = "formula", column = @Column(name = "HEIGHT_FORMULA"))})
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "HEIGHT_UNIT"))
    private Formula height = new Formula();
    
    @NotNull
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "value", column = @Column(name = "LENGTH_VAL")), 
                        @AttributeOverride(name = "formula", column = @Column(name = "LENGTH_FORMULA"))})
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "LENGTH_UNIT"))
    private Formula length = new Formula();    
    
    @NotNull
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "value", column = @Column(name = "WEIGHT_VAL")), 
                        @AttributeOverride(name = "formula", column = @Column(name = "WEIGHT_FORMULA"))})
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WEIGHT_UNIT"))
    private Formula weight = new Formula(); 
    
    @NotNull
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "value", column = @Column(name = "DEPTH_VAL")), 
                        @AttributeOverride(name = "formula", column = @Column(name = "DEPTH_FORMULA"))})
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "DEPTH_UNIT"))
    private Formula depth = new Formula(); 

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
    public Formula getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(Formula width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public Formula getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Formula height) {
        this.height = height;
    }

    /**
     * @return the length
     */
    public Formula getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(Formula length) {
        this.length = length;
    }

    /**
     * @return the weight
     */
    public Formula getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Formula weight) {
        this.weight = weight;
    }

    /**
     * @return the depth
     */
    public Formula getDepth() {
        return depth;
    }

    /**
     * @param depth the depth to set
     */
    public void setDepth(Formula depth) {
        this.depth = depth;
    }
    
}
