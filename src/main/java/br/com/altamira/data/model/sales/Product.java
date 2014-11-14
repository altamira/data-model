package br.com.altamira.data.model.sales;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.altamira.data.model.Resource;

/**
 *
 * @author alessandro.holanda
 */
@Entity(name = "br.com.altamira.data.model.sales")
@Table(name = "SL_PRODUCT", uniqueConstraints = @UniqueConstraint(columnNames = {"CODE", "DESCRIPTION"}))
public class Product extends Resource {

    /**
     *
     */
    private static final long serialVersionUID = -4871377387938455032L;

//    @Id
//    @SequenceGenerator(name = "ProductSequence", sequenceName = "SL_PRODUCT_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSequence")
//    @Column(name = "ID")
//    private Long id;

    @NotNull
    @Size(min = 10)
    @Column(name = "CODE", unique = true, nullable = false)
    private String code = "";

    @NotNull
    @Size(min = 10)
    @Column(name = "DESCRIPTION", unique = true, nullable = false)
    private String description = "";

    @Column(name = "COLOR")
    private String color = "";

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
     */
    public Product() {

    }

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
    public Product(String code, String description, String color,
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
     * @return the id
     */
//    public Long getId() {
//        return id;
//    }

    /**
     * @param id the id to set
     */
//    public void setId(Long id) {
//        this.id = id;
//    }

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
