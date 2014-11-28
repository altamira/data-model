package br.com.altamira.data.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author alessandro.holanda
 */
@Table(name = "MR_RESOURCE")
@javax.persistence.Entity(name = "Resource")
@Inheritance(strategy = InheritanceType.JOINED)
public class Resource extends br.com.altamira.data.model.BaseEntity implements br.com.altamira.data.model.Entity {

    /**
     *
     */
    private static final long serialVersionUID = -73112110881650016L;

    // Guarantee unique id for all entities
    /**
     *
     */
    @Id
    @SequenceGenerator(name = "ResourceSequence", sequenceName = "RESOURCE_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ResourceSequence")
    @Column(name = "ID")
    protected Long id = 0l;
    
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
