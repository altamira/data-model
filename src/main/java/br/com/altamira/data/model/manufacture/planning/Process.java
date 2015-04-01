package br.com.altamira.data.model.manufacture.planning;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.altamira.data.model.serialize.JSonViews;
import br.com.altamira.data.model.serialize.NullCollectionSerializer;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.Entity;

/**
 *
 * @author alessandro.holanda
 */
@Table(name = "MN_PROCESS")
@Entity(name = "br.com.altamira.data.model.manufacture.planning.Process")
public class Process extends br.com.altamira.data.model.Process {

    /**
     *
     */
    private static final long serialVersionUID = 5549369785798723928L;

    @NotNull
    @Size(min = 3)
    @Column(name = "CODE", columnDefinition = "nvarchar2(255)", unique = true, nullable = false)
    private String code = "";

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name = "";

    @JsonView(JSonViews.EntityView.class)
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "process", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<br.com.altamira.data.model.manufacture.process.Operation> operation = new ArrayList<>();
    
    /**
     *
     */
    public Process() {
    }

    /**
     *
     * @param id
     * @param code
     * @param name
     */
    public Process(long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    /*public String getDescription() {
        return description;
    }*/

    /**
     *
     * @param description
     */
    /*public void setDescription(String description) {
        this.description = description;
    }*/

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
    public List<br.com.altamira.data.model.manufacture.process.Operation> getOperation() {
        return operation;
    }

    /**
     *
     * @param operation
     */
    public void setOperation(List<br.com.altamira.data.model.manufacture.process.Operation> operation) {
        this.operation = operation;
    }
}
