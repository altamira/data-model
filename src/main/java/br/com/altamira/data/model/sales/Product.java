package br.com.altamira.data.model.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.common.Material;
import br.com.altamira.data.model.measurement.Expression.UnresolvedTokenException;
import br.com.altamira.data.model.measurement.Formula;
import br.com.altamira.data.model.measurement.Variables;
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
    @AttributeOverride(name = "expression", column = @Column(name = "WIDTH"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WIDTH_UNIT"))
    private Formula width = new Formula();

    @NotNull
    @Embedded
    @AttributeOverride(name = "expression", column = @Column(name = "LENGTH"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "LENGTH_UNIT"))
    private Formula length = new Formula();

    @NotNull
    @Embedded
    @AttributeOverride(name = "expression", column = @Column(name = "HEIGHT"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "HEIGHT_UNIT"))
    private Formula height = new Formula();

    @NotNull
    @Embedded
    @AttributeOverride(name = "expression", column = @Column(name = "DEPTH"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "DEPTH_UNIT"))
    private Formula depth = new Formula();

    @NotNull
    @Embedded
    @AttributeOverride(name = "expression", column = @Column(name = "AREA"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "AREA_UNIT"))
    private Formula area = new Formula();

    @NotNull
    @Embedded
    @AttributeOverride(name = "expression", column = @Column(name = "WEIGHT"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WEIGHT_UNIT"))
    private Formula weight = new Formula();

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
        this.type = type;
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

    /**
     * @return the area
     */
    public Formula getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Formula area) {
        this.area = area;
    }

    /**
     *
     * @param variable
     * @return
     */
    @Override
    public Variables setVariable(Variables variable) {

        try {
            this.width.setVariable(variable);
            variable.put("width", this.getWidth().getValue());
        } catch (UnresolvedTokenException e) {

        }

        try {
            this.length.setVariable(variable);
            variable.put("length", this.getLength().getValue());
        } catch (UnresolvedTokenException e) {

        }

        try {
            this.height.setVariable(variable);
            variable.put("height", this.getHeight().getValue());
        } catch (UnresolvedTokenException e) {

        }

        try {
            this.depth.setVariable(variable);
            variable.put("depth", this.getDepth().getValue());
        } catch (UnresolvedTokenException e) {

        }

        try {
            this.area.setVariable(variable);
            variable.put("area", this.getArea().getValue());
        } catch (UnresolvedTokenException e) {

        }
        
        try {
            this.weight.setVariable(variable);
            variable.put("weight", this.getWeight().getValue());
        } catch (UnresolvedTokenException e) {

        }

        return variable;
    }
}
