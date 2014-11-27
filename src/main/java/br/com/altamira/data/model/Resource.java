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
public class Resource extends br.com.altamira.data.model.Entity {

    /**
     *
     */
    private static final long serialVersionUID = -73112110881650016L;


}
