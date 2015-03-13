package br.com.altamira.data.model.shipping.planning;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.serialize.JSonViews;
import br.com.altamira.data.model.serialize.NullObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
    @JoinColumn(name = "STATUS", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    private Status status;

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
    @Column(name = "COMMENTS", columnDefinition = "CLOB NULL")
    private String comment = "";

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "FINISH")
    private String finish = "";

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "PROJECT")
    private Long project = 0l;

    @JsonIgnore
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CHECKED")
    private Date checked;

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "INVOICE")
    private Long invoice = 0l;

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "TRANSPORT")
    private String transport = "";

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "CONTACT_NAME")
    private String name = "";

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "CONTACT_PHONE")
    private String phone = "";

    @JsonView(JSonViews.EntityView.class)
    @Column(name = "CONTACT_EMAIL")
    private String email = "";

    @JsonView(JSonViews.EntityView.class)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOM", insertable = false, updatable = false)
    private Set<Item> item = new HashSet<>();

    @JsonView(JSonViews.EntityView.class)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOM", insertable = false, updatable = false)
    private List<History> history = new ArrayList<>();

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
     * @return the invoice
     */
    public Long getInvoice() {
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Long invoice) {
        this.invoice = invoice;
    }

    /**
     * @return the transport
     */
    public String getTransport() {
        return transport;
    }

    /**
     * @param transport the transport to set
     */
    public void setTransport(String transport) {
        this.transport = transport;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the history
     */
    public List<History> getHistory() {
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(List<History> history) {
        this.history = history;
    }

}
