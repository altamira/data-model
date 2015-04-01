/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.planning;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.measurement.Variables;
import br.com.altamira.data.model.serialize.JSonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alessandro
 */
@Table(name = "CM_MATERIAL")
@Entity(name = "br.com.altamira.data.model.manufacture.planning.Material")
@Inheritance(strategy = InheritanceType.JOINED)
public class Material extends Resource {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = -4871377399938455032L;

    /**
     *
     */
    @NotNull
    @Size(min = 3)
    @Column(name = "CODE", unique = true, nullable = false)
    protected String code = "";

    /**
     *
     */
    @NotNull
    @Size(min = 5)
    @Column(name = "DESCRIPTION", unique = true, nullable = false)
    protected String description = "";
    
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "PROCESS", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Process process;


    /**
     *
     */
    public Material() {

    }

    /**
     *
     * @param id
     * @param code
     * @param description
     */
    public Material(long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Material(long id, String code, String description, String type) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.type = type;
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
     *
     * @return
     */
    @Override
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonView(JSonViews.ListView.class)
    public String getType() {
        return super.getType();
    }

    public Variables setVariable(Variables variable) {
        // do nothing here, see inherited classes from br.com.altamira.data.model.commom.Material
        return variable;
    }

    /**
     * @return the process
     */
    public Process getProcess() {
        return process;
    }

    /**
     * @param process the process to set
     */
    public void setProcess(Process process) {
        this.process = process;
    }
}
