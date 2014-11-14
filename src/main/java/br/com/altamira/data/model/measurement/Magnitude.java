/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.measurement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "MS_MAGNITUDE")
public class Magnitude extends br.com.altamira.data.model.Measurement {
    
    @NotNull
    @Column(name = "NAME", unique = true, nullable = false)
    private String name = "";

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
    
    
}
