/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.shipping.planning;

import br.com.altamira.data.model.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "MN_BOM")
public class Transport extends Resource {

    /**
     * Serial number ID
     */
    private static final long serialVersionUID = -3725094293364656727L;
    
    @Column(name = "INVOICE")
    private Long invoice = 0l;
    
    @Column(name = "TRANSPORT")
    private String transport = "";
        
    @Column(name = "CONTACT_NAME")
    private String name = "";
    
    @Column(name = "CONTACT_PHONE")
    private String phone = "";
        
    @Column(name = "CONTACT_EMAIL")
    private String email = "";

    /**
     * @return the invoice
     */
    public Long getInvoice() {
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Long invoice) {
        this.invoice = invoice;
    }

    /**
     * @return the transport
     */
    public String getTransport() {
        return transport;
    }

    /**
     * @param transport the transport to set
     */
    public void setTransport(String transport) {
        this.transport = transport;
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

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
