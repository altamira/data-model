package br.com.altamira.data.model.sales;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.common.Material;

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

    @Min(0)
    @NotNull
    @Column(name = "WIDTH")
    private BigDecimal width = BigDecimal.valueOf(0);

    @Min(0)
    @NotNull
    @Column(name = "HEIGHT")
    private BigDecimal height = BigDecimal.valueOf(0);

    @Min(0)
    @NotNull
    @Column(name = "LENGTH")
    private BigDecimal length = BigDecimal.valueOf(0);

    @Min(0)
    @NotNull
    @Column(name = "WEIGHT")
    private BigDecimal weight = BigDecimal.valueOf(0);

    public Product() {
        
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
