/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.common;

import br.com.altamira.data.model.Property;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "CM_COLOR")
public class Color extends Property {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = -4871377399938455032L;

    @NotNull
    @Size(min = 3)
    @Column(name = "CODE")
    private String code = "";

    @NotNull
    @Size(min = 5)
    @Column(name = "NAME")
    private String name = "";

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

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
