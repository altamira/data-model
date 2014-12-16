/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.common;

import br.com.altamira.data.model.Relation;
import br.com.altamira.data.model.serialize.NullObjectSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "CM_MATERIAL_ALIAS")
public class MaterialAlias extends Relation {
    
    @JoinColumn(name = "MATERIAL")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    private br.com.altamira.data.model.common.Material material;
    
    @NotNull
    @Size(min = 3)
    @Column(name = "CODE", unique = true)
    private String code = "";

    @NotNull
    @Size(min = 5)
    @Column(name = "DESCRIPTION")
    private String description = "";    


    /**
     *
     */
    public MaterialAlias() {

    }
    
    /**
     *
     * @param code
     * @param description
     */
    public MaterialAlias(String code, String description) {
        this.code = code;
        this.description = description;
    }
    
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
     * @return the material
     */
    public br.com.altamira.data.model.common.Material getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(br.com.altamira.data.model.common.Material material) {
        this.material = material;
    }
}
