/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Alessandro
 */
public interface Entity extends Serializable {

    /**
     * @return the id
     */
    Long getId();

    /**
     * @param id the id to set
     */
    void setId(Long id);

    @JsonIgnore
    Entity getParent();

    @JsonIgnore
    void setParent(Entity parent);

    /**
     * @param parentType
     */
    @JsonIgnore
    void setParentType(Class<? extends BaseEntity> parentType);

    /**
     * @return the parent
     */
    @JsonIgnore
    Class<? extends Entity> getParentType();

    /**
     * @return the version
     */
    Timestamp getVersion();

    /**
     * @param version the version to set
     */
    void setVersion(Timestamp version);
 
    @Override
    int hashCode();

    /**
     *
     * @param object
     * @return
     */
    @Override
    boolean equals(Object object);

    @Override
    String toString();
    
}
