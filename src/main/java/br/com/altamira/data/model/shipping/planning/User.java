package br.com.altamira.data.model.shipping.planning;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author
 */
@Entity(name = "br.com.altamira.data.model.shipping.planning.User")
@Table(name = "SS_USER")
public class User extends br.com.altamira.data.model.Resource {

    /**
     * Serial number ID
     */
    private static final long serialVersionUID = -3725014293364656727L;

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

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
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
     * @return
     */
    public String getEmail() {
        return email;
    }

}
