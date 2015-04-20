package br.com.altamira.data.model.manufacture.bom;

import br.com.altamira.data.model.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.altamira.data.model.serialize.JSonViews;
import br.com.altamira.data.model.serialize.NullObjectSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Lob;

/**
 *
 * 
 * @author Alessandro
 */
@Entity
@Table(name = "MN_BOM")
public class BOM extends Resource {

    /**
     * Serial number ID
     */
    private static final long serialVersionUID = -3725014293364656727L;
    
    @NotNull
    @Column(name = "BOM_NUMBER", unique = true, nullable = false)
    private Long number = 0l;
    
    @NotNull
    @JoinColumn(name = "STATUS", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    private Status status = new Status(2200l, 1, "Pedido Liberado");

    @NotNull
    @Size(min = 3)
    @Column(name = "CUSTOMER")
    private String customer = "";

    //@NotNull
    //@Size(min = 5)
    @JsonView(JSonViews.EntityView.class)
    @Column(name = "REPRESENTATIVE")
    private String representative = "";

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CREATED")
    private Date created = new Date();

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "DELIVERY")
    private Date delivery = new Date();

    //@NotNull
    //@Size(min = 8, max = 8)
    @JsonView(JSonViews.EntityView.class)
    @Column(name = "QUOTATION", unique = true, nullable = false)
    private String quotation = "";

    @Lob
    @JsonView(JSonViews.EntityView.class)
    @Column(name = "COMMENTS", columnDefinition="CLOB NULL")
    private String comment = "";

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "FINISH")
    private String finish = "";

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "PROJECT")
    private Long project = 0l;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CHECKED")
    private Date checked;

    @JsonView(JSonViews.EntityView.class)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "bom", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Item> item;

    /**
     *
     */
    public BOM() {
        this.item = new ArrayList<>();
    }
    
    /**
     *
     * @param number
     * @param customer
     */
    public BOM(Long number, String customer) {
        this.number = number;
        this.customer = customer;
    }

    /**
     *
     * @param number
     * @param customer
     * @param checked
     */
    public BOM(Long number, String customer, Date checked) {
        this.number = number;
        this.customer = customer;
        this.checked = checked;
    }
    
    /**
     *
     * @param id
     * @param number
     * @param customer
     * @param checked
     */
    public BOM(Long id, Long number, String customer, Date checked) {
    	this.id = id;
        this.number = number;
        this.customer = customer;
        this.checked = checked;
    }
    
    /**
     *
     * @param id
     * @param number
     * @param customer
     * @param checked
     * @param created
     * @param delivery
     */
    public BOM(Long id, Long number, String customer, Date created, Date delivery, Date checked) {
    	this.id = id;
        this.number = number;
        this.customer = customer;
        this.created = created;
        this.delivery = delivery;
        this.checked = checked;
    }
    
    /**
     *
     * @return
     */
    public Long getNumber() {
        return number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(Long number) {
        this.number = number;
    }

    /**
     *
     * @return
     */
    public String getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     *
     * @return
     */
    public String getRepresentative() {
        return representative;
    }

    /**
     *
     * @param representative
     */
    public void setRepresentative(String representative) {
        this.representative = representative;
    }

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
    public Date getDelivery() {
        return delivery;
    }

    /**
     *
     * @param delivery
     */
    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    /**
     *
     * @return
     */
    public String getQuotation() {
        return quotation;
    }

    /**
     *
     * @param quotation
     */
    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    /**
     *
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     */
    public String getFinish() {
        return finish;
    }

    /**
     *
     * @param finish
     */
    public void setFinish(String finish) {
        this.finish = finish;
    }

    /**
     *
     * @return
     */
    public Long getProject() {
        return project;
    }

    /**
     *
     * @param project
     */
    public void setProject(Long project) {
        this.project = project;
    }

    /**
     *
     * @return
     */
    public List<Item> getItem() {
        return item;
    }

    /**
     *
     * @param item
     */
    public void setItem(List<Item> item) {
        this.item = (List<Item>) item;
    }
    
    /**
     * @return the checked
     */
    public boolean getChecked() {
        return checked != null;
    }
    
    /**
     * @param checked
     */
    public void setChecked(boolean checked) {
        this.checked = checked ? new Date() : null;
    }
    
    /**
     * @return the checked
     */
    @JsonIgnore
    public Date getCheckedDate() {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    @JsonIgnore
    public void setCheckedDate(Date checked) {
        this.checked = checked;
    }

}
