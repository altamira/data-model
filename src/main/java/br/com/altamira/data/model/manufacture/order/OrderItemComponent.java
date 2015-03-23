package br.com.altamira.data.model.manufacture.order;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.manufacture.bom.Component;
import br.com.altamira.data.model.measurement.Measure;

@Entity(name = "br.com.altamira.data.model.manufacturing.order.OrderItemComponent")
@Table(name = "MN_ORDER_ITEM_CMP")
public class OrderItemComponent extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -96266958106783345L;
	
	@JoinColumn(name = "MN_ORDER", referencedColumnName = "ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Order order;
	
	@JoinColumn(name = "COMPONENT", referencedColumnName = "ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Component component;
	
	@Temporal(value = TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;
	
	@NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "PRODUCED"))
	@AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "PRODUCED_UNIT"))
	private Measure produced = new Measure();
	
	@NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "REMAINING"))
	@AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "REMAINING_UNIT"))
	private Measure remaining = new Measure();
	
	@NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY"))
	@AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
	private Measure quantity = new Measure();

	/**
	 * 
	 * @return
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * 
	 * @param order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * 
	 * @return
	 */
	public Component getComponent() {
		return component;
	}

	/**
	 * 
	 * @param component
	 */
	public void setComponent(Component component) {
		this.component = component;
	}

	/**
	 * 
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 
	 * @return
	 */
	public Measure getProduced() {
		return produced;
	}

	/**
	 * 
	 * @param produced
	 */
	public void setProduced(Measure produced) {
		this.produced = produced;
	}

	/**
	 * 
	 * @return
	 */
	public Measure getRemaining() {
		return remaining;
	}

	/**
	 * 
	 * @param remaining
	 */
	public void setRemaining(Measure remaining) {
		this.remaining = remaining;
	}

	/**
	 * 
	 * @return
	 */
	public Measure getQuantity() {
		return quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(Measure quantity) {
		this.quantity = quantity;
	}

}
