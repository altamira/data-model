package br.com.altamira.data.model.shipping.planning;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.serialize.JSonViews;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * 
 * @author Alessandro
 */
@Table(name = "MN_BOM")
@Entity(name = "br.com.altamira.data.model.shipping.planning.BOM")
public class BOM extends Resource {

    /**
     * Serial number ID
     */
    private static final long serialVersionUID = -3725014293364656727L;
    
    @NotNull
    @Column(name = "BOM_NUMBER", unique = true, nullable = false)
    private Long number = 0l;

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

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "COMMENTS")
    private String comment = "";

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "FINISH")
    private String finish = "";

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "PROJECT")
    private Long project = 0l;
        
    @JsonView(JSonViews.EntityView.class)
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="BOM", insertable=false, updatable=false)
    private Set<Item> item = new HashSet<>();
    
    /**
     *
     */
    public BOM() {
        this.item = new HashSet<>();
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
     * @param id
     * @param number
     * @param customer
     */
    public BOM(Long id, Long number, String customer) {
    	this.id = id;
        this.number = number;
        this.customer = customer;
    }
    
    /**
     *
     * @param id
     * @param number
     * @param customer
     * @param created
     * @param delivery
     */
    public BOM(Long id, Long number, String customer, Date created, Date delivery) {
    	this.id = id;
        this.number = number;
        this.customer = customer;
        this.created = created;
        this.delivery = delivery;
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
    public Set<Item> getItem() {
        return item;
    }

    /**
     *
     * @param item
     */
    public void setItem(Set<Item> item) {
        this.item = item;
    }

}
