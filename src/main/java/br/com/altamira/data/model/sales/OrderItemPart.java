package br.com.altamira.data.model.sales;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.altamira.data.model.Resource;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author alessandro.holanda
 */
@Entity(name = "br.com.altamira.data.model.sales.OrderItemPart")
@Table(name = "SL_ORDER_ITEM_PART")
public class OrderItemPart extends Resource {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = -4871377387938455032L;

//    @Id
//    @SequenceGenerator(name = "OrderItemPartSequence", sequenceName = "SL_ORDER_ITEM_PART_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderItemPartSequence")
//    @Column(name = "ID")
//    private Long id;

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
    @Min(0)
    @Column(name = "QUANTITY")
    private BigDecimal quantity = BigDecimal.valueOf(0);

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

    @JsonIgnore
    @JoinColumn(name = "ORDER_ITEM", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderItem orderItem;

    /*
     @JoinColumn(name = "CODE", referencedColumnName = "CODE", insertable=false, updatable=false)
     @JoinColumn(name = "PRODUCT", referencedColumnName = "ID", insertable = false, updatable = false)
     @ManyToOne(optional = false, fetch = FetchType.LAZY)
     private Product product;
     */
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
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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

    /**
     *
     * @return
     */
    @JsonIgnore
    public OrderItem getOrderItem() {
        return orderItem;
    }

    /**
     *
     * @param orderItem
     */
    @JsonIgnore
    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    /*public Product getProduct() {
     return product;
     }

     public void setProduct(Product product) {
     this.product = product;
     }*/
}
