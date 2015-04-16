/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.shipping.planning;

import br.com.altamira.data.model.Resource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alessandro
 */
@Entity(name = "br.com.altamira.data.model.shipping.planning.AccessToken")
@Table(name = "SS_ACCESS_TOKEN")
public class AccessToken extends Resource {

    /**
     * Serial number ID
     */
    private static final long serialVersionUID = -3725014293364656727L;

    @NotNull
    @Size(min = 3)
    @Column(name = "ACCESS_TOKEN")
    private String accessToken = "";

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CREATED")
    private Date created = new Date();

    @JsonIgnore
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    /**
     *
     * @return
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     *
     * @param accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     *
     * @return
     */
    public Date getCreated() {
        return created;
    }

    /**
     *
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
