/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.purchase;

import br.com.altamira.data.model.measurement.Expression.UnresolvedTokenException;
import br.com.altamira.data.model.measurement.Formula;
import br.com.altamira.data.model.measurement.Variables;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@Table(name = "PR_STEEL", 
        uniqueConstraints = @UniqueConstraint(columnNames = {"LAMINATION", "TREATMENT", "THICKNESS", "WIDTH", "LENGTH"}))
@Entity(name = "br.com.altamira.data.model.purchase.Steel")
public class Steel extends Material {

    /**
     *
     */
    private static final long serialVersionUID = -6256290660697921883L;

    @Basic(optional = false)
    @Column(name = "LAMINATION", columnDefinition = "char(2)")
    private String lamination = "";

    @Basic(optional = false)
    @Column(name = "TREATMENT", columnDefinition = "char(2)")
    private String treatment = "";

    @NotNull
    @Embedded
    @AttributeOverride(name = "expression", column = @Column(name = "THICKNESS"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "THICKNESS_UNIT"))
    private Formula thickness = new Formula();

    @NotNull
    @Embedded
    @AttributeOverride(name = "expression", column = @Column(name = "WIDTH"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WIDTH_UNIT"))
    private Formula width = new Formula();

    @NotNull
    @Embedded
    @AttributeOverride(name = "expression", column = @Column(name = "LENGTH"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "LENGTH_UNIT"))
    private Formula length = new Formula();

    @NotNull
    @Embedded
    @AttributeOverride(name = "expression", column = @Column(name = "WEIGHT"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WEIGHT_UNIT"))
    private Formula weight = new Formula();

    public Steel() {

    }

    /**
     *
     * @param id
     * @param code
     * @param description
     */
    public Steel(long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    /**
     *
     * @param id
     * @param code
     * @param description
     */
    public Steel(long id, String code, String description, String type) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.type = type;
    }

    /**
     *
     * @param lamination
     * @param treatment
     * @param thickness
     * @param width
     * @param length
     */
    public Steel(String lamination, String treatment,
            Formula thickness, Formula width, Formula length) {
        this.lamination = lamination;
        this.treatment = treatment;
        this.thickness = thickness;
        this.width = width;
        this.length = length;
    }

    /**
     *
     * @return
     */
    public String getLamination() {
        return lamination;
    }

    /**
     *
     * @param lamination
     */
    public void setLamination(String lamination) {
        this.lamination = lamination;
    }

    /**
     *
     * @return
     */
    public String getTreatment() {
        return treatment;
    }

    /**
     *
     * @param treatment
     */
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    /**
     * @return the thickness
     */
    public Formula getThickness() {
        return thickness;
    }

    /**
     * @param thickness the thickness to set
     */
    public void setThickness(Formula thickness) {
        this.thickness = thickness;
    }

    /**
     * @return the width
     */
    public Formula getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(Formula width) {
        this.width = width;
    }

    /**
     * @return the length
     */
    public Formula getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(Formula length) {
        this.length = length;
    }

    /**
     * @return the weight
     */
    public Formula getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Formula weight) {
        this.weight = weight;
    }

    /**
     *
     * @param variable
     * @return
     */
    @Override
    public Variables setVariable(Variables variable) {

        try {
            this.thickness.setVariable(variable);
            variable.put("thickness", this.getThickness().getValue());
        } catch (UnresolvedTokenException e) {

        }

        try {
            this.width.setVariable(variable);
            variable.put("width", this.getWidth().getValue());
        } catch (UnresolvedTokenException e) {

        }

        try {
            this.length.setVariable(variable);
            variable.put("length", this.getLength().getValue());
        } catch (UnresolvedTokenException e) {

        }

        try {
            this.weight.setVariable(variable);
            variable.put("weight", this.getWeight().getValue());
        } catch (UnresolvedTokenException e) {

        }
        
        return variable;
    }
}
