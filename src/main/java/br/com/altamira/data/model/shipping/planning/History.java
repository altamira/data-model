/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.shipping.planning;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.serialize.JSonViews;
import br.com.altamira.data.model.serialize.NullObjectSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "MN_BOM_HISTORY")
public class History extends Resource {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = 7448803906699786256L;

    @JsonIgnore
    @JoinColumn(name = "BOM", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BOM bom = new BOM();

    @NotNull
    @JoinColumn(name = "STATUS", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    private Status status;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "HISTORY_DATE")
    private Date date = new Date();

    @Lob
    @JsonView(JSonViews.EntityView.class)
    @Column(name = "COMMENTS", columnDefinition = "CLOB NULL")
    private String comment = "";

    @JoinColumn(name = "CREATED_BY", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonSerialize(nullsUsing = NullObjectSerializer.class)
    private User createdBy;

    public History() {
        this.parentType = BOM.class;
    }

    /**
     *
     *
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("History requires a BOM instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        setBOM((BOM) parent);
    }

    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getBOM();
    }

    /**
     *
     * @return
     */
    @JsonIgnore
    public BOM getBOM() {
        return bom;
    }

    /**
     *
     * @param bom
     */
    @JsonIgnore
    public void setBOM(BOM bom) {
        this.bom = bom;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the createdBy
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    @JsonIgnore
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
