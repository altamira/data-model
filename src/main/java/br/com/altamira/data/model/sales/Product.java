package br.com.altamira.data.model.sales;

import br.com.altamira.data.model.common.Color;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.altamira.data.model.common.Material;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "COLOR", referencedColumnName = "ID", insertable = false, updatable = false, nullable = false, unique = false)
    private Color color = new Color();

    @NotNull
    @Min(0)
    @Column(name = "WIDTH")
    private BigDecimal width = BigDecimal.valueOf(0);

    @NotNull
    @Min(0)
    @Column(name = "HEIGHT")
    private BigDecimal height = BigDecimal.valueOf(0);

    @NotNull
    @Min(0)
    @Column(name = "LENGTH")
    private BigDecimal length = BigDecimal.valueOf(0);

    @NotNull
    @Min(0)
    @Column(name = "WEIGHT")
    private BigDecimal weight = BigDecimal.valueOf(0);

    /**
     *
     * @param code
     * @param description
     * @param color
     * @param width
     * @param height
     * @param length
     * @param weight
     */
    public Product(String code, String description, Color color,
            BigDecimal width, BigDecimal height, BigDecimal length,
            BigDecimal weight) {
        super();
        this.code = code;
        this.description = description;
        this.color = color;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
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
    public BigDecimal getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     *
     * @param length
     */
    public void setLength(BigDecimal length) {
        this.length = length;
    }

    /**
     *
     * @return
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

}
