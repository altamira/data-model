package br.com.altamira.data.model.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import br.com.altamira.security.oauth2.serialize.NullCollectionSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author
 */
@Entity
@Table(name = "SS_PERMISSION")
public class Permission extends br.com.altamira.data.model.Resource {

    /**
     *
     */
    private static final long serialVersionUID = -7539995003808419586L;

    @NotNull
    @Size(max = 50)
    @Column(name = "RESOURCE_NAME")
    private String resourceName = "";

    @NotNull
    @Size(max = 255)
    @Column(name = "PERMISSION")
    private String permission = "";

    @JsonIgnore
    //@JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permission", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Profile> profiles = new ArrayList<Profile>();

    /**
     *
     */
    public Permission() {

    }

    /**
     *
     * @param id
     * @param resourceName
     * @param permission
     */
    public Permission(Long id, String resourceName, String permission) {

        this.id = id;
        this.resourceName = resourceName;
        this.permission = permission;

    }

    /**
     *
     * @return
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     *
     * @param resourceName
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     *
     * @return
     */
    public String getPermission() {
        return permission;
    }

    /**
     *
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     *
     * @return
     */
    public List<Profile> getProfiles() {
        return profiles;
    }

    /**
     *
     * @param profiles
     */
    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

}
