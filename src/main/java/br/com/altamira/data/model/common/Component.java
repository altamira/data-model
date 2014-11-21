/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.common;

import br.com.altamira.data.model.Resource;
import br.com.altamira.data.model.measurement.Measure;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "CM_COMPONENT")
public class Component extends Resource {

    @ManyToOne
    @JoinColumn(name = "FK_PARENT_MATERIAL")
    public br.com.altamira.data.model.common.Material parentFolder;

    @OneToMany(mappedBy = "component")
    public List<br.com.altamira.data.model.common.Material> component = new ArrayList<br.com.altamira.data.model.common.Material>();

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "QUANTITY_VAL"))
    @AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "QUANTITY_UNIT"))
    private Measure quantity = new Measure();
}
