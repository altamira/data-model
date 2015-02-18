/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.bom;

import br.com.altamira.data.model.serialize.JSonViews;
import br.com.altamira.data.model.serialize.NullCollectionSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alessandro
 */
// ALTAMIRA-76: revert changes in material
@Embeddable
public class Material implements Serializable {

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

    /**
     *
     */
    @JsonView(JSonViews.EntityView.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "parent", fetch = FetchType.LAZY)
    protected List<br.com.altamira.data.model.common.Component> component = new ArrayList<>();

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
        //this.id = id;
        this.code = code;
        this.description = description;
    }

    public Material(long id, String code, String description, String type) {
        //this.id = id;
        this.code = code;
        this.description = description;
        //this.type = type;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return 0l;
    }

    /**
     * @return the id
     */
    public void setId(Long id) {
        
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
     * @return the component
     */
    public List<br.com.altamira.data.model.common.Component> getComponent() {
        return component;
    }

    /**
     * @param component the component to set
     */
    public void setComponent(List<br.com.altamira.data.model.common.Component> component) {
        this.component = component;
    }
    
    /**
     *
     * @return
     */
    //@Override
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonView(JSonViews.ListView.class)
    public String getType() {
        return this.getType();
    }

}
