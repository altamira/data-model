/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.common;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.serialize.JSonViews;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alessandro
 */
@Table(name = "CM_MATERIAL")
@Entity(name = "common.Material")
@Inheritance(strategy = InheritanceType.JOINED)
public class Material extends Resource {
    /**
     * Serial version ID
     */
    private static final long serialVersionUID = -4871377399938455032L;

    @NotNull
    @Size(min = 3)
    @Column(name = "CODE", unique = true, nullable = false)
    private String code = "";

    @NotNull
    @Size(min = 5)
    @Column(name = "NAME", unique = true, nullable = false)
    private String name = "";

    @JsonView(JSonViews.EntityView.class)
    @OneToMany(/*cascade = {CascadeType.PERSIST, CascadeType.REMOVE},*/ mappedBy = "parent", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Component> parent = new ArrayList<>();
    
    @JsonView(JSonViews.EntityView.class)
    @OneToMany(/*cascade = {CascadeType.PERSIST, CascadeType.REMOVE},*/ mappedBy = "material", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Component> component = new ArrayList<>();
        
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
