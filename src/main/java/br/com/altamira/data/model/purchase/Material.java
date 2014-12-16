/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.purchase;

import br.com.altamira.data.model.measurement.Measure;
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
@Entity(name = "purchasing.Material")
@Table(name = "PR_MATERIAL", uniqueConstraints = @UniqueConstraint(columnNames = {"LAMINATION", "TREATMENT", "THICKNESS_VAL", "WIDTH_VAL", "LENGTH_VAL"}))
public class Material extends br.com.altamira.data.model.common.Material {

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
    @AttributeOverride(name = "value", column = @Column(name = "THICKNESS_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "THICKNESS_UNIT"))
    private Measure thickness = new Measure();
    
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "WIDTH_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "WIDTH_UNIT"))
    private Measure width = new Measure();
    
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "LENGTH_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "LENGTH_UNIT"))
    private Measure length = new Measure();
    
    /**
     *
     */
    public Material() {
    }

    /**
     *
     * @param id
     * @param code
     * @param description
     */
    public Material(long id, String code, String description) {
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
    public Material(long id, String code, String description, String type) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.setType(type);
    } 
    
    /**
     *
     * @param lamination
     * @param treatment
     * @param thickness
     * @param width
     * @param length
     */
    public Material(String lamination, String treatment,
            Measure thickness, Measure width, Measure length) {
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
    public Measure getThickness() {
        return thickness;
    }

    /**
     * @param thickness the thickness to set
     */
    public void setThickness(Measure thickness) {
        this.thickness = thickness;
    }

    /**
     * @return the width
     */
    public Measure getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(Measure width) {
        this.width = width;
    }

    /**
     * @return the length
     */
    public Measure getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(Measure length) {
        this.length = length;
    }

}
