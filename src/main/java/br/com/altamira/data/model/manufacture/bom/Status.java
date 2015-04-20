/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.bom;

import br.com.altamira.data.model.Resource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alessandro
 */
@Table(name = "SH_BOM_STATUS")
@Entity(name = "br.com.altamira.data.model.manufacture.bom.Status")
public class Status extends Resource {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6410960411790843867L;

	/**
     *
     */
    @Min(1)
    @Column(name = "CODE")
    private int code;

    /**
     *
     */
    @NotNull
    @Size(min = 5)
    @Column(name = "DESCRIPTION", unique = true, nullable = false)
    private String description = "";

    public Status() {
        
    }
    
    public Status(Long id, int code, String description) {
        super();
        this.id = id;
        this.code = code;
        this.description = description;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the status to set
     */
    public void setCode(int code) {
        this.code = code;
    }

}
