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
//@javax.persistence.MappedSuperclass
@Table(name = "MR_RELATION")
@javax.persistence.Entity(name = "Relation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Relation extends br.com.altamira.data.model.BaseEntity implements br.com.altamira.data.model.Entity {

    /**
     *
     */
    private static final long serialVersionUID = -4355944251210357445L;
    
    // Guarantee unique id for all entities
    /**
     *
     */
    /*@Id
    @SequenceGenerator(name = "RelationSequence", sequenceName = "RELATION_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RelationSequence")
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
