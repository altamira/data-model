package br.com.altamira.data.model.shipping.planning;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.common.Document;
import br.com.altamira.data.model.manufacture.bom.BOM;
import br.com.altamira.data.model.manufacture.bom.BOMItemPart;
import br.com.altamira.data.model.measurement.Measure;
import br.com.altamira.data.model.serialize.NullObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * Represents a sales order item
 */
@Entity(name = "br.com.altamira.data.model.shipping.PlanningItem")
@Table(name = "SH_PLANNING_ITEM", uniqueConstraints = @UniqueConstraint(columnNames = {"PLANNING", "BOM_ITEM_PART", "DELIVERY"}))
public class PlanningItem extends Document {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = 7448803904699786256L;

//    @Id
//    @SequenceGenerator(name = "PlanningItemSequence", sequenceName = "SL_ORDER_ITEM_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PlanningItemSequence")
//    @Column(name = "ID")
//    private Long id;

    @JsonIgnore
    @JoinColumn(name = "PLANNING", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Planning planning = new Planning();

    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    @JoinColumn(name = "BOM_ITEM_PART", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BOMItemPart bomItemPart;
    
    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "DELIVERY")
    private Date delivery = new Date();
    
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();
    /**
     *
     */
    public PlanningItem() {
        this.parentType = Planning.class;
    }
    
    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("PlanningItem requires a Planning instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }
     
        setPlanning((Planning)parent);
    }
    
    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getPlanning();
    }
    
    /**
     * @return the planning
     */
    public Planning getPlanning() {
        return planning;
    }

    /**
     * @param planning the planning to set
     */
    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    /**
     * @return the delivery
     */
    public Date getDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    /**
     * @return the bomItemPart
     */
    public BOMItemPart getBomItemPart() {
        return bomItemPart;
    }

    /**
     * @param bomItemPart the bomItemPart to set
     */
    public void setBomItemPart(BOMItemPart bomItemPart) {
        this.bomItemPart = bomItemPart;
    }

    /**
     * @return the quantity
     */
    public Measure getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Measure quantity) {
        this.quantity = quantity;
    }

}
