package br.com.altamira.data.model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
    /*@Id
    @SequenceGenerator(name = "ResourceSequence", sequenceName = "RESOURCE_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ResourceSequence")
    @Column(name = "ID")
    protected Long id = 0l;
    
    /**
     * @return the id
     */
    /*@Override
    public Long getId() {
        return this.id;
    }*/

    /**
     * @param id the id to set
     */
    /*@Override
    public void setId(Long id) {
        this.id = id;
    }*/
    
}
