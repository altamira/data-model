package br.com.altamira.data.model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author alessandro.holanda
 */
//@javax.persistence.MappedSuperclass
@Table(name = "MR_RELATION")
@javax.persistence.Entity(name = "Relation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Relation extends br.com.altamira.data.model.Entity {

    /**
     *
     */
    private static final long serialVersionUID = -4355944251210357445L;

}
