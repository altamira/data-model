/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.measurement;

import br.com.altamira.data.serialize.JSonViews;
import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "MS_UNIT")
public class Unit extends br.com.altamira.data.model.Measurement {

    @NotNull
    @Column(name = "NAME", unique = true, nullable = false)
    private String name = "";

    @NotNull
    @Column(name = "SYMBOL", unique = true, nullable = false)
    private String symbol = "";

    @JsonView(JSonViews.EntityView.class)
    @ManyToOne(/*cascade = CascadeType.ALL,*/ optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "MAGNITUDE"/*, referencedColumnName = "ID", insertable = false, updatable = false*/, nullable = false, unique = false)
    //@JoinTable(name="MS_MAGNITUDE", joinColumns={@JoinColumn(name="CUSTOMER_ID", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="DOG_ID", referencedColumnName="id")})
    private Magnitude magnitude = new Magnitude();

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
     * @return the unit
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the magnitude
     */
    public Magnitude getMagnitude() {
        return magnitude;
    }

    /**
     * @param magnitude the magnitude to set
     */
    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }
}
