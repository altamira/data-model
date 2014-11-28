package br.com.altamira.data.model.manufacturing.process;

import br.com.altamira.data.model.measurement.Measure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Embedded;

/**
 *
 * @author alessandro.holanda
 */
@Entity
@Table(name = "MN_PRODUCE")
public class Produce extends br.com.altamira.data.model.Relation {

    /**
     *
     */
    private static final long serialVersionUID = 8786534973807974496L;
    
    @NotNull
    @Size(min = 10)
    @Column(name = "CODE", columnDefinition = "nvarchar2(255)")
    private String code;

    @NotNull
    @Size(min = 10)
    @Column(name = "DESCRIPTION", columnDefinition = "nvarchar2(255)")
    private String description;

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();

    @JsonIgnore
    @JoinColumn(name = "OPERATION", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Operation operation;
    
    public Produce() {
        this.parentType = Operation.class;
    }

    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("Produce requires a Operation instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        setOperation((Operation) parent);
    }

    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getOperation();
    }
    
    /**
     *
     * @return
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     *
     * @param operation
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
