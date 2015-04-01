package br.com.altamira.data.model.manufacture.process;

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

import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 *
 * @author alessandro.holanda
 */
@Table(name = "MN_PROCESS")
@Entity(name = "br.com.altamira.data.model.manufacture.process.Process")
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
    @Column(name = "NAME", unique = true, nullable = false, columnDefinition = "nvarchar2(255)")
    private String name = "";

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "DESCRIPTION", columnDefinition = "CLOB NULL")
    private String description = "";

    @JsonView(JSonViews.EntityView.class)
    //@JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "process", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Revision> revision = new ArrayList<>();

    @JsonView(JSonViews.EntityView.class)
    //@JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "process", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Operation> operation = new ArrayList<>();

    @JsonView(JSonViews.EntityView.class)
    //@JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "process", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<br.com.altamira.data.model.common.Material> material = new ArrayList<>();

    /**
     *
     */
    public Process() {
        this.operation = new ArrayList<>();
    }

    /**
     *
     * @param id
     * @param code
     * @param description
     */
    public Process(long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
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
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
    public List<Revision> getRevision() {
        return revision;
    }

    /**
     *
     * @param revision
     */
    public void setRevision(List<Revision> revision) {
        this.revision = revision;
    }

    /**
     *
     * @return
     */
    public List<Operation> getOperation() {
        return operation;
    }

    /**
     *
     * @param operation
     */
    public void setOperation(List<Operation> operation) {
        this.operation = operation;
    }

    /**
     *
     * @return
     */
    public List<br.com.altamira.data.model.common.Material> getMaterial() {
        return material;
    }

    /**
     *
     * @param material
     */
    public void setMaterial(List<br.com.altamira.data.model.common.Material> material) {
        this.material = material;
    }

}
