/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture;

import br.com.altamira.data.model.common.Component;
import br.com.altamira.data.model.common.Material;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "MN_TOOLING")
public class Tooling extends Material {

    /**
     *
     */
    private static final long serialVersionUID = 1823172807710930495L;

    @Override
    @JsonIgnore
    public List<Component> getComponent() {
        return new ArrayList<>();
    }
}