/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture;


import br.com.altamira.data.model.Resource;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author Alessandro
 */
@Entity(name = "br.com.altamira.data.model.manufacture.Operation")
@Table(name = "MN_OPERATION")
public class Operation extends Resource {

    /**
     *
     */
    @NotNull
    @Size(min = 5)
    @Column(name = "NAME", unique = true, nullable = false, columnDefinition = "nvarchar2(50)")
    private String name = "";
    
    /**
     *
     */
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "DESCRIPTION", columnDefinition = "CLOB NULL")
    private String description = "";
    
    public Operation() {
        
    }
    
    public Operation(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    public Operation(Long id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
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
