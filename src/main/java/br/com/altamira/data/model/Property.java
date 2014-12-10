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
@Table(name = "MR_PROPERTY")
@javax.persistence.Entity(name = "Property")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Property extends br.com.altamira.data.model.BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1777813641499544646L;
    
    // Guarantee unique id for all entities
    /**
     *
     */
    /*@Id
    @SequenceGenerator(name = "PropertySequence", sequenceName = "PROPERTY_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PropertySequence")
    @Column(name = "ID")
    protected Long id = 0l;*/

    /**
     * @return the id
     */
    /*public Long getId() {
        return this.id;
    }*/

    /**
     * @param id the id to set
     */
    /*public void setId(Long id) {
        this.id = id;
    }*/

}