/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.purchasing;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.serialize.NullCollectionSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "PR_REQUEST_ITEM", uniqueConstraints = @UniqueConstraint(name = "UK1", columnNames = {"REQUEST", "MATERIAL", "ARRIVAL_DATE"}))
@NamedQueries({
    @NamedQuery(name = "RequestItem.list", query = "SELECT r FROM RequestItem r JOIN FETCH r.material JOIN r.request rq WHERE rq.id = :requestId"),
    @NamedQuery(name = "RequestItem.findById", query = "SELECT r FROM RequestItem r WHERE r.id = :id")})
public class RequestItem extends Resource {

    /**
     *
     */
    private static final long serialVersionUID = 748027754605400931L;

//    @Id
//    @SequenceGenerator(name = "RequestItemSequence", sequenceName = "PR_REQUEST_ITEM_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RequestItemSequence")
//    @Column(name = "ID")
//    private Long id;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ARRIVAL_DATE")
    private Date arrival = new Date();

    @Basic(optional = false)
    @Column(name = "WEIGHT")
    private BigDecimal weight = BigDecimal.valueOf(0);

    @JoinColumn(name = "REQUEST", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Request request;

    @JsonSerialize(using = NullCollectionSerializer.class)
    @JoinColumn(name = "MATERIAL", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Material material;

    /*@OneToMany(cascade = CascadeType.ALL,mappedBy = "requestItem", fetch = FetchType.LAZY)
     private Set<PurchasePlanningItem> purchasePlanningItem;*/
    /**
     *
     */
    public RequestItem() {
    }

    /**
     *
     * @param arrival
     * @param weight
     */
    public RequestItem(Date arrival, BigDecimal weight) {
        this.arrival = arrival;
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
    public Date getArrival() {
        return arrival;
    }

    /**
     *
     * @param arrival
     */
    public void setArrival(Date arrival) {
        this.arrival = arrival;
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
    @XmlTransient
    public Request getRequest() {
        return request;
    }

    /**
     *
     * @param request
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     *
     * @return
     */
    public Material getMaterial() {
        return material;
    }

    /**
     *
     * @param material
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /*@XmlTransient
     public Set<PurchasePlanningItem> getPurchasePlanningItem() {
     return purchasePlanningItem;
     }

     public void setPurchasePlanningItem(
     Set<PurchasePlanningItem> purchasePlanningItem) {
     this.purchasePlanningItem = purchasePlanningItem;
     }*/
}
