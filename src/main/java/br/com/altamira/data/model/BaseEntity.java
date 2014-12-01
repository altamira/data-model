/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model;

import br.com.altamira.data.serialize.JSonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@javax.persistence.MappedSuperclass
//@Table(name = "MR_ENTITY")
//@javax.persistence.Entity(name = "Entity")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseEntity implements br.com.altamira.data.model.Entity {

    /**
     *
     */
    private static final long serialVersionUID = -73112170881659955L;
    
    @Version
    @Column(name = "VERSION")
    @JsonView(JSonViews.EntityView.class)
    private java.sql.Timestamp version = new java.sql.Timestamp(0);

    @NotNull
    @JsonIgnore
    @Column(name = "LAST_MODIFIED")
    private Long lastModified = System.currentTimeMillis();

    // TODO: store class name from subclass in an ENTITY table
    @NotNull
    @JsonIgnore
    @Column(name = "ENTITY_CLASS")
    private String entityClass;

    @Transient
    protected Class<? extends br.com.altamira.data.model.BaseEntity> parentType;

    public BaseEntity() {
        this.entityClass = this.getClass().getName();
    }
    /**
     *
     * @return
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @PreUpdate
    @PrePersist
    void updateModificationTimestamp() {
        this.lastModified = System.currentTimeMillis();
        this.entityClass = this.getClass().getName();
    }

    /**
     * @return the version
     */
    @Override
    public java.sql.Timestamp getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    @Override
    public void setVersion(java.sql.Timestamp version) {
        this.version = version;
    }

    /**
     * @return the parent
     */
    @JsonIgnore
    @Override
    public Class<? extends br.com.altamira.data.model.Entity> getParentType() {
        return parentType;
    }

    /**
     * @param parentType
     */
    @JsonIgnore
    @Override
    public void setParentType(Class<? extends br.com.altamira.data.model.BaseEntity> parentType) {
        this.parentType = parentType;
    }

    @JsonIgnore
    @Override
    public void setParent(Entity parent) {
        throw new UnsupportedOperationException("You are calling br.com.altamira.data.model.Entity.setParent(). You should override this method in child class.");
        //this.setParent(parent);
    }

    @JsonIgnore
    @Override
    public Entity getParent() {
        //throw new UnsupportedOperationException("You are calling br.com.altamira.data.model.Entity.getParent(). You should override this method in child class.");
        //return this.getParent();
        return null;
    }

    /**
     * @return the lastModified
     */
    public Long getLastModified() {
        return lastModified;
    }

    /**
     * @return the entityClass
     */
    public String getEntityClass() {
        return entityClass;
    }

}
