/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.execution;

import br.com.altamira.data.model.shipping.execution.*;
import br.com.altamira.data.model.measurement.Measure;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
public class Remaining {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = 7448803904699786256L;

    private Long id;
    
    @Temporal(value = TemporalType.DATE)
    private Date delivery = new Date();

    @NotNull
    @Embedded
    private Measure remaining = new Measure("kg");

    public Remaining() {
        
    }

    public Remaining(Long id, Date delivery) {
        this.id = id;
        this.delivery = delivery;
    }
    
    public Remaining(Long id, Date delivery, Measure remaining) {
        this.id = id;
        this.delivery = delivery;
        this.remaining = remaining;
    }
    
    public Remaining(Long id, Date delivery, BigDecimal value) {
        this.id = id;
        this.delivery = delivery;
        this.remaining.setValue(value);
    }
    
    /**
     * @return the delivery
     */
    public Date getDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    /**
     * @return the remaining
     */
    public Measure getRemaining() {
        return remaining;
    }

    /**
     * @param remaining the remaining to set
     */
    public void setRemaining(Measure remaining) {
        this.remaining = remaining;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
}
