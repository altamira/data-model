/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.sales;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Alessandro
 */
@Entity(name = "sales.Component")
@Table(name = "SL_COMPONENT")
public class Component extends Product {

    /**
     *
     */
    private static final long serialVersionUID = -4811377387938455032L;    
    

    /**
     *
     */
    public Component() {
        
    }

    /**
     *
     * @param id
     * @param code
     * @param description
     */
    public Component(long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    /**
     *
     * @param id
     * @param code
     * @param description
     * @param type
     */
    public Component(long id, String code, String description, String type) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.type = type;
    }     
}
