/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.purchasing;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.serialize.JSonViews;
import br.com.altamira.data.serialize.NullCollectionSerializer;

import com.fasterxml.jackson.annotation.JsonView;
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
@Table(name = "PR_REQUEST")
@NamedQueries({
    @NamedQuery(name = "Request.list", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findById", query = "SELECT r FROM Request r WHERE r.id = :id"),
    @NamedQuery(name = "Request.current", query = "SELECT r FROM Request r WHERE r.id = (SELECT MAX(rr.id) FROM Request rr WHERE rr.sent IS NULL)"),
    @NamedQuery(name = "Request.items", query = "SELECT r FROM RequestItem r WHERE r.request = :requestId")})
public class Request extends Resource {

    /**
     *
     */
    private static final long serialVersionUID = -2066957562882901235L;
    
//    @Id
//    @SequenceGenerator(name = "RequestSequence", sequenceName = "PR_REQUEST_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RequestSequence")
//    @Column(name = "ID")
//    private Long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @NotNull
    @Size(min = 3, max = 50)
    @Basic(optional = false)
    @Column(name = "CREATOR", columnDefinition = "nvarchar2(255)")
    private String creator = "";

    //@JsonSerialize(using = DateSerializer.class)
    @Column(name = "SENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sent = new Date();

    @JsonView(JSonViews.EntityView.class)
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "request", fetch = FetchType.LAZY, orphanRemoval = true)
    //@JoinColumn(name="REQUEST")
    private Set<RequestItem> item = new HashSet<RequestItem>();

    /*@ManyToOne(optional = true, fetch = FetchType.LAZY)
     private QuotationRequest quotationRequest;*/
    /**
     *
     */
    public Request() {
    }

    /**
     *
     * @param created
     * @param creator
     */
    public Request(Date created, String creator) {
        this.created = created;
        this.creator = creator;
        this.sent = null;
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
    public Date getCreated() {
        return created;
    }

    /**
     *
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     *
     * @return
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     *
     * @return
     */
    public Date getSent() {
        return sent;
    }

    /**
     *
     * @param sent
     */
    public void setSent(Date sent) {
        this.sent = sent;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Set<RequestItem> getItem() {
        return item;
    }

    /**
     *
     * @param items
     */
    public void setItem(Set<RequestItem> items) {
        this.item = items;
    }

    /*@XmlTransient
     public QuotationRequest getQuotationRequest() {
     return quotationRequest;
     }

     public void setQuotationRequest(QuotationRequest quotationRequest) {
     this.quotationRequest = quotationRequest;
     }*/
}
