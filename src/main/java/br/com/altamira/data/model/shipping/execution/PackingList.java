/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.shipping.execution;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.measurement.Measure;
import br.com.altamira.data.model.serialize.JSonViews;
import br.com.altamira.data.model.serialize.NullCollectionSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@Entity(name = "br.com.altamira.data.model.shipping.execution.PackingList")
@Table(name = "SH_PACKINGLIST")
public class PackingList extends Resource {

    /**
     * Serial number ID
     */
    private static final long serialVersionUID = -3725013293364656727L;
    
    @JsonIgnore
    @JoinColumn(name = "BOM", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BOM bom = new BOM();
    
    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "DELIVERY")
    private Date delivery = new Date();    

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "WEIGHT"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WEIGHT_UNIT"))
    private Measure weight = new Measure("kg");
    
    @JsonView(JSonViews.EntityView.class)
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="PACKINGLIST", insertable=false, updatable=false)
    private Set<Delivered> delivered = new HashSet<>();

    public PackingList() {
        this.parentType = BOM.class;
    }
    
    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("Component requires a Item instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        setBOM((BOM) parent);
    }

    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getBOM();
    }
    
    /**
     *
     * @return
     */
    @JsonIgnore
    public BOM getBOM() {
        return bom;
    }

    /**
     *
     * @param bom
     */
    @JsonIgnore
    public void setBOM(BOM bom) {
        this.bom = bom;
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
     * @return the delivered
     */
    public Set<Delivered> getDelivered() {
        return delivered;
    }

    /**
     * @param delivered the delivered to set
     */
    public void setDelivered(Set<Delivered> delivered) {
        this.delivered = delivered;
    }

    /**
     * @return the weight
     */
    public Measure getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Measure weight) {
        this.weight = weight;
    }
}
