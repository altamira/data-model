/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.measurement;

import static br.com.altamira.data.model.measurement.UnitFactory.UnitFactory;
import java.io.Serializable;
import java.math.BigDecimal;
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

    /**
     *
     */
    private static final long serialVersionUID = 3833764960269130334L;

    @NotNull
    @Column(name = "VAL", nullable = false, precision = 19, scale = 10)
    private BigDecimal value = BigDecimal.valueOf(0);

    //@JsonView(JSonViews.EntityView.class)
    @ManyToOne(/*cascade = CascadeType.ALL,*/optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "UNIT", referencedColumnName = "ID", insertable = false, updatable = false/*, nullable = false, unique = false*/)
    private Unit unit = new Unit();

    public Measure() {
        super();
    }

    public Measure(Measure measure) {
        if (measure.getValue() == null) {
            this.value = BigDecimal.ZERO;
        } else {
            this.value = measure.getValue();
        }
        this.unit = new Unit(measure.getUnit());
    }

    public Measure(Unit unit) {
        this.value = BigDecimal.ZERO;
        this.unit = new Unit(unit);
    }

    public Measure(String symbol) {
        this.value = BigDecimal.ZERO;
        this.unit = UnitFactory(symbol);
    }
    
    public Measure(BigDecimal value, Unit unit) {
        if (value == null) {
            this.value = BigDecimal.ZERO;
        } else {
            this.value = value;
        }
        this.unit = new Unit(unit);
    }

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
        if (value == null) {
            this.value = BigDecimal.ZERO;
        } else {
            this.value = value;
        }
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

    public Measure add(Measure measure) {
        Measure m = new Measure(this);
        m.setValue(m.getValue().add(measure.getValue()));
        return m;
    }
    
    public Measure subtract(Measure measure) {
        Measure m = new Measure(this);
        m.setValue(m.getValue().subtract(measure.getValue()));
        return m;
    }    
    
    public Measure min(Measure measure) {
        Measure m = new Measure(this);
        m.setValue(m.getValue().min(measure.getValue()));
        return m;
    }
}
