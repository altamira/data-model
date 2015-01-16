/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture;

import br.com.altamira.data.model.common.Material;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "MN_TOOLING")
public class Tooling extends Material {

    /**
     *
     */
    private static final long serialVersionUID = 1823172807710930495L;

    /**
     *
     */
    public Tooling() {
        
    }
    
    /**
     *
     * @param id
     * @param code
     * @param description
     */
    public Tooling(long id, String code, String description) {
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
    public Tooling(long id, String code, String description, String type) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.type = type;
    } 
}
