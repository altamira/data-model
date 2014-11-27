package br.com.altamira.data.model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author alessandro.holanda
 */
@Table(name = "MR_PROCESS")
@javax.persistence.Entity(name = "Process")
@Inheritance(strategy = InheritanceType.JOINED)
public class Process extends br.com.altamira.data.model.Entity {

    /**
     *
     */
    private static final long serialVersionUID = 1777813641467344646L;

}
