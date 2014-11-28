/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Alessandro
 */
@Table(name = "MR_MEASUREMENT")
@javax.persistence.Entity(name = "Measurement")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Measurement extends br.com.altamira.data.model.BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1777813641499344646L;
    
    // Guarantee unique id for all entities
    /**
     *
     */
    @Id
    @SequenceGenerator(name = "MeasurementSequence", sequenceName = "MEASUREMENT_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MeasurementSequence")
    @Column(name = "ID")
    protected Long id = 0l;

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Measurement)) {
            return false;
        }
        Measurement other = (Measurement) object;
        if ((this.id == null && other.getId() != null)
                || (this.id != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + "[ id=" + this.id + " ]";
    }    
}
