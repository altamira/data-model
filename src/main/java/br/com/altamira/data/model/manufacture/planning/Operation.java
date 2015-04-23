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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
    @Column(name = "NAME", unique = true, nullable = false, columnDefinition = "nvarchar2(50)")
    private String name = "";

    @Transient
    @JsonView(JSonViews.ListView.class)
    private Produce produce;

    public Operation() {

    }
    
    /**
     * 
     * @param id
     * @param name
     * @param startDate
     * @param quantity
     * @param quantityUnit
     */
    public Operation(Long id, String name, Date startDate, BigDecimal quantity, Unit quantityUnit) {
        this.id = id;
        this.name = name;
        this.produce = new Produce(startDate, new Measure(quantity, quantityUnit));
    }

    /**
     *
     * @param id
     * @param name
     * @param startDate
     * @param quantity
     * @param unit
     */
    public Operation(Long id, String name, Date startDate, BigDecimal quantity, Unit quantityUnit,BigDecimal weight, Unit weightUnit) {
        this.id = id;
        this.name = name;
        this.produce = new Produce(startDate, new Measure(quantity, quantityUnit),new Measure(weight, weightUnit));
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
        
        @JsonInclude(Include.NON_NULL)
        private Measure weight;

        public Produce(Date startDate, Measure quantity) {
            this.startDate = startDate;
            this.quantity = quantity;
        }
        
        public Produce(Date startDate, Measure quantity,Measure weight) {
            this.startDate = startDate;
            this.quantity = quantity;
            this.weight = weight;
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
        
        public Measure getWeight() {
			return weight;
		}

		public void setWeight(Measure weight) {
			this.weight = weight;
		}

    }
}
