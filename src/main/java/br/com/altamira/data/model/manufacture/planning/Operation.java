/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.planning;

import java.math.BigDecimal;
import java.util.Date;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.measurement.Measure;
import br.com.altamira.data.model.measurement.Unit;
import br.com.altamira.data.model.serialize.JSonViews;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

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
    
    @Transient
    @JsonView(JSonViews.ListView.class)
    private Produce produce;
    
    /**
     * 
     * @param id
     * @param description
     * @param startDate
     * @param quantityValue
     * @param quantityUnit
     */
    public Operation(Long id,String description,Date startDate, BigDecimal quantityValue, Unit quantityUnit){
    	this.id = id;
    	this.description = description;
    	this.produce = new Produce(startDate, new Measure(quantityValue,quantityUnit));
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
    
    public Produce getProduce() {
		return produce;
	}

	public void setProduce(Produce produce) {
		this.produce = produce;
	}

	// ALTAMIRA-161 : Manufacture Planning - Operation summary
	class Produce {

		private Date startDate;
		private Measure quantity;

		public Produce(Date startDate, Measure quantity) {
			this.startDate = startDate;
			this.quantity = quantity;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Measure getQuantity() {
			return quantity;
		}

		public void setQuantity(Measure quantity) {
			this.quantity = quantity;
		}

	}
}
