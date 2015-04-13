package br.com.altamira.data.model.security;

import br.com.altamira.data.model.serialize.NullCollectionSerializer;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.OneToMany;

/**
 *
 * @author
 */
@Entity
@Table(name = "SS_PROFILE")
public class Profile extends br.com.altamira.data.model.Resource {

    /**
     * Serial number ID
     */
    private static final long serialVersionUID = -3725014293364656727L;

    @NotNull
    @Size(max = 50)
    @Column(name = "NAME")
    private String name = "";

    @JsonIgnore
    @JsonSerialize(using = NullCollectionSerializer.class)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profiles")
    private List<User> users = new ArrayList<>();

    @JsonIgnore
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Permission> permission = new ArrayList<>();

    /**
     *
     */
    public Profile() {

    }

    /**
     *
     * @param id
     * @param name
     */
    public Profile(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * @return the permission
     */
    public List<Permission> getPermission() {
        return permission;
    }

    /**
     * @param permission the permission to set
     */
    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }

}
