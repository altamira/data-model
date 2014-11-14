/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model;

import br.com.altamira.data.serialize.JSonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public abstract class Entity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -73112170881659955L;

    // Guarantee unique id for all entities
    /**
     *
     */
    @Id
    @SequenceGenerator(name = "EntitySequence", sequenceName = "ENTITY_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EntitySequence")
    @Column(name = "ID")
    protected Long id = 0l;

    @Version
    @Column(name = "VERSION")
    @JsonView(JSonViews.EntityView.class)
    private java.sql.Timestamp version;

    @NotNull
    @Column(name = "LAST_MODIFIED")
    private Long lastModified = System.currentTimeMillis();

    // TODO: store class name from subclass in an ENTITY table
//    @NotNull
    @Column(name = "ENTITY_CLASS")
    private String entityClass;
    
    @Transient
    protected Class<? extends br.com.altamira.data.model.Entity> parentType;
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Entity)) {
            return false;
        }
        Entity other = (Entity) object;
        if ((this.id == null && other.getId() != null)
                || (this.id != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + "[ id=" + id + " ]";
    }

    /**
     *
     * @return
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @PreUpdate
    void updateModificationTimestamp() {
        lastModified = System.currentTimeMillis();
        //entityClass = getTypeClass().getName();
    }

    /*private Class<? extends br.com.altamira.data.model.Entity> getTypeClass() {
     Class<? extends br.com.altamira.data.model.Entity> clazz = (Class<? extends br.com.altamira.data.model.Entity>) ((ParameterizedType) this.getClass()
     .getGenericSuperclass()).getActualTypeArguments()[0];
     return clazz;
     }*/

    /**
     * @return the version
     */
    public java.sql.Timestamp getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(java.sql.Timestamp version) {
        this.version = version;
    }

    /**
     * @return the parent
     */
    @JsonIgnore
    public Class<? extends br.com.altamira.data.model.Entity> getParentType() {
        return parentType;
    }

    /**
     * @param parentType
     */
    @JsonIgnore
    public void setParentType(Class<? extends br.com.altamira.data.model.Entity> parentType) {
        this.parentType = parentType;
    }

    @JsonIgnore
    public void setParent(Entity parent) {
        throw new UnsupportedOperationException ("You are calling br.com.altamira.data.model.Entity.setParent(). You should override this method in child class.");
    }
    
    @JsonIgnore
    public Entity getParent() {
        throw new UnsupportedOperationException ("You are calling br.com.altamira.data.model.Entity.getParent(). You should override this method in child class.");
    }

}
