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
@Table(name = "MR_PROCESS")
@javax.persistence.Entity(name = "Process")
@Inheritance(strategy = InheritanceType.JOINED)
public class Process extends br.com.altamira.data.model.BaseEntity implements br.com.altamira.data.model.Entity {

    /**
     *
     */
    private static final long serialVersionUID = 1777813641467344646L;
        
    // Guarantee unique id for all entities
    /**
     *
     */
    /*@Id
    @SequenceGenerator(name = "ProcessSequence", sequenceName = "PROCESS_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProcessSequence")
    @Column(name = "ID")
    protected Long id = 0l;*/

    /**
     * @return the id
     */
    /*public Long getId() {
        return this.id;
    }*/

    /**
     * @param id the id to set
     */
    /*public void setId(Long id) {
        this.id = id;
    }*/

}
