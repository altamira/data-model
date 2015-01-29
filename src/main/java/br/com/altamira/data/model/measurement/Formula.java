/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.measurement;

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
    @Column(name = "VALUE", nullable = false, columnDefinition = "nvarchar2(255)")
    private String expression = "";

    //@JsonView(JSonViews.EntityView.class)
    @ManyToOne(/*cascade = CascadeType.ALL,*/optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "UNIT", referencedColumnName = "ID", insertable = false, updatable = false/*, nullable = false, unique = false*/)
    private Unit unit = new Unit();

    @Transient
    private Map<String, BigDecimal> variable = new Variables();

    /**
     * @return the value
     */
    public BigDecimal getValue() {
        BigDecimal result = new BigDecimal(0);

        Expression exp = new Expression(this.expression);
        exp.setVariables(this.variable);
        exp.setPrecision(10);

        try {
            result = exp.eval();
        } catch (Exception e) {
            String message = e.getMessage();
        }

        return result;
    }

    /**
     * @param value the value to set
     */
    /*public void setValue(String value) {
     this.expression = value;
     }*/
    public String getExpression() {
        return this.expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
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
     * @return the variable
     */
    public Map<String, BigDecimal> getVariable() {
        return this.variable;
    }

    /**
     * @param variables
     */
    public void setVariable(Variables variables) {

        if (variables == null || variables.isEmpty()) {
            return;
        }

        variables.forEach((k, v) -> {
            this.variable.put(k, v);
        });

    }

}
