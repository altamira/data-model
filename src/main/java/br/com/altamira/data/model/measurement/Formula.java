/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.measurement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@Embeddable
public class Formula implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3833764960269130334L;

    @NotNull
    @Column(name = "VAL", nullable = false, precision = 19, scale = 10)
    private BigDecimal value = BigDecimal.valueOf(0);
    
    @NotNull
    @Column(name = "FORMULA", nullable = false, columnDefinition = "nvarchar2(255)")
    private String formula = "";
    
    //@JsonView(JSonViews.EntityView.class)
    @ManyToOne(/*cascade = CascadeType.ALL,*/optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "UNIT", referencedColumnName = "ID", insertable = false, updatable = false/*, nullable = false, unique = false*/)
    private Unit unit = new Unit();

    @Transient
    private Map<String, BigDecimal> variable = new Variables();
    
    /**
     * @param variables
     * @return the value
     */
    public BigDecimal getValue(Map<String, BigDecimal> variables) {
        if (this.formula == null && this.formula.isEmpty()) {
            return value;
        }
        
        setVariable(variables);
        
        Expression exp = new Expression(this.formula);
        exp.setVariables(this.variable);
        
        this.value = exp.eval();
        
        return this.value;
    }
    
    public BigDecimal getValue() {
        return getValue(null);
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

    /**
     * @return the formula
     */
    public String getFormula() {
        return formula;
    }

    /**
     * @param formula the formula to set
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * @return the variable
     */
    public Map<String, BigDecimal> getVariable() {
        return this.variable;
    }

    /**
     * @param variables
     */
    public void setVariable(Map<String, BigDecimal> variables) {
                
        if (variables == null || variables.isEmpty()) {
            return;
        }

        variables.forEach((k, v) -> {
            this.variable.put(k, v);
        });

    }

}
