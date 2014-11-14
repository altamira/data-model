package br.com.altamira.data.model.sales;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.Resource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Lob;
import javax.persistence.UniqueConstraint;

/**
 *
 * Represents a sales order item
 */
@Entity(name = "br.com.altamira.data.model.sales.OrderItem")
@Table(name = "SL_ORDER_ITEM", uniqueConstraints = @UniqueConstraint(columnNames = {"SALES_ORDER", "ITEM"}))
public class OrderItem extends Resource {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = 7448803904699786256L;

//    @Id
//    @SequenceGenerator(name = "OrderItemSequence", sequenceName = "SL_ORDER_ITEM_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderItemSequence")
//    @Column(name = "ID")
//    private Long id;

    @JsonIgnore
    @JoinColumn(name = "SALES_ORDER", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Order order;

    @NotNull
    @Min(1)
    @Column(name = "ITEM")
    private int item = 0;

    @NotNull
    @Lob
    @Column(name = "DESCRIPTION", length = 100000)
    private String description = "";

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderItem", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderItemPart> parts;

    /**
     *
     */
    public OrderItem() {
        this.parts = new ArrayList<>();
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
    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    /**
     *
     * @param order
     */
    @JsonIgnore
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     *
     * @return
     */
    public int getItem() {
        return item;
    }

    /**
     *
     * @param item
     */
    public void setItem(int item) {
        this.item = item;
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
    public List<OrderItemPart> getParts() {
        return parts;
    }

    /**
     *
     * @param parts
     */
    public void setPart(List<OrderItemPart> parts) {
        this.parts = parts;
    }

}
