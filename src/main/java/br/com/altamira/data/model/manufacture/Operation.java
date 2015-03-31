/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture;


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
@Entity(name = "br.com.altamira.data.model.manufacture.Operation")
@Table(name = "MN_OPERATION")
public class Operation extends Resource {

    /**
     *
     */
    @NotNull
    @Size(min = 5)
    @Column(name = "DESCRIPTION", unique = true, nullable = false)
    private String description = "";

    /*@JsonView(JSonViews.EntityView.class)
     @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "operation", fetch = FetchType.LAZY, orphanRemoval = false)
     private List<br.com.altamira.data.model.manufacture.process.Operation> operation = new ArrayList<>();*/
    
    public Operation() {
        
    }
    
    public Operation(Long id, String description) {
        super();
        this.id = id;
        this.description = description;
    }
    
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

    /**
     *
     * @return
     */
    /*public List<br.com.altamira.data.model.manufacture.process.Operation> getOperation() {
     return operation;
     }*/
    /**
     *
     * @param operation
     */
    /*public void setOperation(
     List<br.com.altamira.data.model.manufacture.process.Operation> operation) {
     this.operation = operation;
     }*/
}
