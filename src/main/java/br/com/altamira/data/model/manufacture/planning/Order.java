package br.com.altamira.data.model.manufacture.planning;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.altamira.data.model.common.Document;
import br.com.altamira.data.model.serialize.JSonViews;
import com.fasterxml.jackson.annotation.JsonView;

/**
 *
 * @author alessandro.holanda
 */
@Entity(name = "br.com.altamira.data.model.manufacture.planning.Order")
@Table(name = "MN_ORDER")
public class Order extends Document {

    /**
     * Serial number ID
     */
    private static final long serialVersionUID = -3725014293364656727L;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    private Date createdDate = new Date();
    
    @Temporal(value = TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;
        
    @JsonView(JSonViews.EntityView.class)
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "order", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Produce> produce;

    /**
     *
     */
    public Order() {
        this.produce = new ArrayList<>();
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
    public Date getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     */
    public List<Produce> getProduce() {
        return produce;
    }

    /**
     *
     * @param produce
     */
    public void setProduce(List<Produce> produce) {
        this.produce = produce;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
