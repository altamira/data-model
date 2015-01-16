/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.purchase;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "PR_INPUTS")
public class Inputs extends br.com.altamira.data.model.common.Material {

    /**
     *
     */
    private static final long serialVersionUID = 1900892879991346801L;
    
    public Inputs() {
        
}
    
    /**
     *
     * @param id
     * @param code
     * @param description
     */
    public Inputs(long id, String code, String description) {
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
    public Inputs(long id, String code, String description, String type) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.type = type;
    } 

    
}
