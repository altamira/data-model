package br.com.altamira.data.model.manufacture.order;

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

import br.com.altamira.data.model.common.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Lob;
import javax.persistence.UniqueConstraint;

/**
 *
 * Represents a sales order item
 */
@Entity(name = "br.com.altamira.data.model.manufacturing.order.OrderItem")
@Table(name = "MN_ORDER_ITEM", uniqueConstraints = @UniqueConstraint(columnNames = {"MN_ORDER", "ITEM"}))
public class OrderItem extends Document {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = 7448803904699786256L;

    @JsonIgnore
    @JoinColumn(name = "MN_ORDER", referencedColumnName = "ID")
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

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "orderItem", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<OrderItemPart> parts;

    /**
     *
     */
    public OrderItem() {
        this.parts = new ArrayList<>();
    }

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
