/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.purchasing;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.altamira.data.model.Resource;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "PR_MATERIAL",
        uniqueConstraints = @UniqueConstraint(columnNames = {"LAMINATION", "TREATMENT", "THICKNESS", "WIDTH", "LENGTH"}))
@NamedQueries({
    @NamedQuery(name = "Material.list", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findById", query = "SELECT m FROM Material m WHERE m.id = :id"),
    @NamedQuery(name = "Material.findByLamination", query = "SELECT m FROM Material m WHERE m.lamination = :lamination"),
    @NamedQuery(name = "Material.findByTreatment", query = "SELECT m FROM Material m WHERE m.treatment = :treatment"),
    @NamedQuery(name = "Material.findByThickness", query = "SELECT m FROM Material m WHERE m.thickness = :thickness"),
    @NamedQuery(name = "Material.findByWidth", query = "SELECT m FROM Material m WHERE m.width = :width"),
    @NamedQuery(name = "Material.findByLength", query = "SELECT m FROM Material m WHERE m.length = :length"),
    @NamedQuery(name = "Material.findByTax", query = "SELECT m FROM Material m WHERE m.tax = :tax"),
    @NamedQuery(name = "Material.findUnique", query = "SELECT m FROM Material m WHERE m.lamination = :lamination AND m.treatment = :treatment AND m.thickness = :thickness AND m.width = :width AND m.length = :length")})
public class Material extends Resource {

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
    private String lamination;

    @Basic(optional = false)
    @Column(name = "TREATMENT", columnDefinition = "char(2)")
    private String treatment;

    @Basic(optional = false)
    @Column(name = "THICKNESS")
    private BigDecimal thickness;

    @Basic(optional = false)
    @Column(name = "WIDTH")
    private BigDecimal width;

    @Basic(optional = false)
    @Column(name = "LENGTH")
    private BigDecimal length;

    @Column(name = "TAX")
    private BigDecimal tax;

    /*@JoinColumn(name = "COMPANY", referencedColumnName = "ID", columnDefinition = "number default 1")
     @ManyToOne(optional = true, fetch = FetchType.LAZY)
     private Company company;*/
//    @OneToMany(/*cascade = CascadeType.ALL,*/mappedBy = "material", fetch = FetchType.LAZY)
//    private Set<MaterialStandard> materialStandardSet;
//    @OneToMany(/*cascade = CascadeType.ALL,*/mappedBy = "material", fetch = FetchType.LAZY)
//    private Set<SupplierPriceList> supplierPriceListSet;
//    @OneToMany(/*cascade = CascadeType.ALL,*/mappedBy = "material", fetch = FetchType.LAZY)
//    private Set<RequestItem> requestItemSet;
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
     * @return the id
     */
//    public Long getId() {
//        return id;
//    }

    /**
     * @param id the id to set
     */
//    public void setId(Long id) {
//        this.id = id;
//    }

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

    //@XmlTransient
    //@JsonIgnore
    /*public Company getCompany() {
     return company;
     }

     public void setCompany(Company company) {
     this.company = company;
     }*/
    /*@XmlTransient
     public Set<MaterialStandard> getMaterialStandardSet() {
     return materialStandardSet;
     }

     public void setMaterialStandardSet(Set<MaterialStandard> materialStandardSet) {
     this.materialStandardSet = materialStandardSet;
     }

     @XmlTransient
     public Set<SupplierPriceList> getSupplierPriceListSet() {
     return supplierPriceListSet;
     }

     public void setSupplierPriceListSet(
     Set<SupplierPriceList> supplierPriceListSet) {
     this.supplierPriceListSet = supplierPriceListSet;
     }

     @XmlTransient
     public Set<RequestItem> getRequestItemSet() {
     return requestItemSet;
     }

     public void setRequestItemSet(Set<RequestItem> requestItemSet) {
     this.requestItemSet = requestItemSet;
     }*/
}
