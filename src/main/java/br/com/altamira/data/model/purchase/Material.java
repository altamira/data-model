/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.purchase;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 *
 * @author Alessandro
 */
@Entity(name = "purchasing.Material")
@Table(name = "PR_MATERIAL",
        uniqueConstraints = @UniqueConstraint(columnNames = {"LAMINATION", "TREATMENT", "THICKNESS", "WIDTH", "LENGTH"}))
public class Material extends br.com.altamira.data.model.common.Material {

    /**
     *
     */
    private static final long serialVersionUID = -6256290660697921883L;

//    @Id
//    @SequenceGenerator(name = "MaterialSequence", sequenceName = "PR_MATERIAL_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MaterialSequence")
//    @Column(name = "ID")
//    private Long id;

    @Basic(optional = false)
    @Column(name = "LAMINATION", columnDefinition = "char(2)")
    private String lamination = "";

    @Basic(optional = false)
    @Column(name = "TREATMENT", columnDefinition = "char(2)")
    private String treatment = "";

    @Basic(optional = false)
    @Column(name = "THICKNESS")
    private BigDecimal thickness = BigDecimal.valueOf(0);

    @Basic(optional = false)
    @Column(name = "WIDTH")
    private BigDecimal width = BigDecimal.valueOf(0);

    @Basic(optional = false)
    @Column(name = "LENGTH")
    private BigDecimal length = BigDecimal.valueOf(0);

    @Column(name = "TAX")
    private BigDecimal tax = BigDecimal.valueOf(0);

    /**
     *
     */
    public Material() {
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
            BigDecimal thickness, BigDecimal width, BigDecimal length) {
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
     *
     * @return
     */
    public BigDecimal getThickness() {
        return thickness;
    }

    /**
     *
     * @param thickness
     */
    public void setThickness(BigDecimal thickness) {
        this.thickness = thickness;
    }

    /**
     *
     * @return
     */
    public BigDecimal getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     *
     * @param length
     */
    public void setLength(BigDecimal length) {
        this.length = length;
    }

    /**
     *
     * @return
     */
    public BigDecimal getTax() {
        return tax;
    }

    /**
     *
     * @param tax
     */
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

}
