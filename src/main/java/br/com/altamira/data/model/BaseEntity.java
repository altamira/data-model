/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model;

import br.com.altamira.data.model.serialize.JSonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
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

    @Id
    @SequenceGenerator(name = "EntitySequence", sequenceName = "ENTITY_SEQUENCE", initialValue = 50000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EntitySequence")
    @Column(name = "ID")
    protected Long id = 0l;

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
    //@JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Column(name = "ENTITY_CLASS")
    protected String type = "";

    /**
     *
     */
    @Transient
    protected Class<? extends br.com.altamira.data.model.BaseEntity> parentType;

    /**
     *
     */
    public BaseEntity() {
        this.type = this.getClass().getName()/*.substring("br.com.altamira.data.model".length() + 1)*/;
    }

    /**
     *
     * @param id
     */
    protected BaseEntity(Long id) {
        this.id = id;
        this.type = this.getClass().getName();
    }

    /**
     *
     * @param entity
     */
    protected BaseEntity(BaseEntity entity) {
        this.id = entity.getId();
        this.version = entity.getVersion();
        this.lastModified = entity.getLastModified();
        this.type = this.getClass().getName();
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

    /**
     *
     * @param parent
     */
    @JsonIgnore
    @Override
    public void setParent(Entity parent) {
        throw new UnsupportedOperationException("You are calling br.com.altamira.data.model.Entity.setParent(). You should override this method in child class.");
        //this.setParent(parent);
    }

    /**
     *
     * @return
     */
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    /*public void setType(String type) {
     this.type = type;
     }*/
    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) object;
        if ((this.id == null && other.getId() != null)
                || (this.id != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + "[ id=" + this.id + " ]";
    }
}
