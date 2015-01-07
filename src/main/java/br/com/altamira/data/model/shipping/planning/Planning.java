package br.com.altamira.data.model.shipping.planning;

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
import javax.validation.constraints.NotNull;

import br.com.altamira.data.model.common.Document;
import br.com.altamira.data.model.serialize.JSonViews;
import com.fasterxml.jackson.annotation.JsonView;

/**
 *
 * @author alessandro.holanda
 */
@Entity(name = "br.com.altamira.data.model.shipping.Planning")
@Table(name = "SH_PLANNING")
public class Planning extends Document {

    /**
     * Serial number ID
     */
    private static final long serialVersionUID = -3725014293364656727L;

//    @Id
//    @SequenceGenerator(name = "PlanningSequence", sequenceName = "SL_ORDER_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PlanningSequence")
//    @Column(name = "ID")
//    private Long id;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CREATED")
    private Date created = new Date();

    @JsonView(JSonViews.EntityView.class)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "planning", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<PlanningItem> items;

    /**
     *
     */
    public Planning() {
        this.items = new ArrayList<>();
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
    public List<PlanningItem> getItems() {
        return items;
    }

    /**
     *
     * @param items
     */
    public void setItems(List<PlanningItem> items) {
        this.items = (List<PlanningItem>) items;
    }

}
