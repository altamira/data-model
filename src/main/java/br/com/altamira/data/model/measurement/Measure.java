/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.measurement;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@Embeddable
public class Measure implements Serializable {

    @NotNull
    @Column(name = "VAL")
    private BigDecimal value = BigDecimal.valueOf(0);

    //@JsonView(JSonViews.EntityView.class)
    @ManyToOne(/*cascade = CascadeType.ALL,*/ optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIT", referencedColumnName = "ID", insertable = false, updatable = false, nullable = false, unique = false)
    private Unit unit;

    /**
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return the unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
