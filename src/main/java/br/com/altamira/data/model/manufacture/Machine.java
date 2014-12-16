/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "MN_MACHINE")
public class Machine extends br.com.altamira.data.model.common.Material {
    
    /**
     *
     */
    private static final long serialVersionUID = 5462259250446467012L;

    /**
     *
     */
    public Machine() {
        
    }
    
    /**
     *
     * @param id
     * @param code
     * @param description
     */
    public Machine(long id, String code, String description) {
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
    public Machine(long id, String code, String description, String type) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.setType(type);
    }     
}
