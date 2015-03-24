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

//    @Id
//    @SequenceGenerator(name = "OrderSequence", sequenceName = "SL_ORDER_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderSequence")
//    @Column(name = "ID")
//    private Long id;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "order", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Produce> produce;

    /**
     *
     */
    public Order() {
        this.produce = new ArrayList<>();
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

}
