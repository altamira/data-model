package br.com.altamira.data.model.security;

import br.com.altamira.data.model.serialize.JSonViews;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import br.com.altamira.security.oauth2.serialize.NullCollectionSerializer;

import com.fasterxml.jackson.annotation.JsonView;

/**
 *
 * @author
 */
@Entity
@Table(name = "SS_USER")
public class User extends br.com.altamira.data.model.Resource {

    /**
     * Serial number ID
     */
    private static final long serialVersionUID = -3725014293364656727L;

    @NotNull
    @Size(min = 3)
    @Column(name = "USERNAME", unique = true)
    private String user = "";

    @NotNull
    @Size(min = 3)
    @Column(name = "PASSWORD")
    private String password = "";

    @NotNull
    @Size(min = 1)
    @Column(name = "FIRST_NAME")
    private String firstName = "";

    @NotNull
    @Size(min = 1)
    @Column(name = "LAST_NAME")
    private String lastName = "";

    @NotNull
    @Size(min = 5)
    @Column(name = "EMAIL")
    private String email = "";

    @JsonView(JSonViews.EntityView.class)
//    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<AccessToken> accessTokens = new ArrayList<>();

    @JsonView(JSonViews.EntityView.class)
//    @JsonSerialize(using = NullCollectionSerializer.class)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ss_user_profile", joinColumns = {
        @JoinColumn(name = "USER_ID", nullable = true, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "PROFILE_ID",
                        nullable = true, updatable = false)})
    private List<Profile> profiles = new ArrayList<>();

    /**
     *
     */
    public User() {

    }

    /**
     *
     * @param id
     * @param user
     */
    public User(Long id, String user) {
        this.id = id;
        this.user = user;
    }

    /**
     *
     * @return
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public List<AccessToken> getAccessTokens() {
        return accessTokens;
    }

    /**
     *
     * @param accessTokens
     */
    public void setAccessTokens(List<AccessToken> accessTokens) {
        this.accessTokens = accessTokens;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
