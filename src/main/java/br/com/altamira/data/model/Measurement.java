/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
    
    public Measurement() {
        super();
    }
    
    public Measurement(Measurement measurement) {
        super(measurement);
    }
}
