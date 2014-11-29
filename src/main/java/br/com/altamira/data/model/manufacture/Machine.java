/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture;

import br.com.altamira.data.model.common.Material;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "MN_MACHINE")
public class Machine extends Material {
    
}
