/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.planning;

import br.com.altamira.data.model.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alessandro
 */
@Entity(name = "br.com.altamira.data.model.manufacture.planning.Operation")
@Table(name = "MN_OPERATION")
public class Operation extends Resource {

    /**
     *
     */
    @NotNull
    @Size(min = 5)
    @Column(name = "DESCRIPTION", unique = true, nullable = false)
    private String description = "";

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
