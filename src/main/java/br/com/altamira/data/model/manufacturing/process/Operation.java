package br.com.altamira.data.model.manufacturing.process;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.altamira.data.serialize.JSonViews;
import br.com.altamira.data.serialize.NullCollectionSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author alessandro.holanda
 */
@Entity
@Table(name = "MN_OPERATION", uniqueConstraints={@UniqueConstraint(columnNames={"PROCESS", "SEQ"})})
public class Operation extends br.com.altamira.data.model.Operation {

    /**
     *
     */
    private static final long serialVersionUID = 4778350055794788171L;

    @JsonIgnore
    @JoinColumn(name = "PROCESS", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Process process;

    @NotNull
    @Min(1)
    @Column(name = "SEQ")
    private int sequence;

    @NotNull
    @Size(min = 3)
    @Column(name = "NAME", columnDefinition = "nvarchar2(255)")
    private String name;

    @NotNull
    @Size(min = 1)
    @JsonView(JSonViews.EntityView.class)
    @Column(name = "DESCRIPTION", columnDefinition = "nvarchar2(700)")
    private String description;

    @JsonView(JSonViews.EntityView.class)
    @JoinColumn(name = "SKETCH", referencedColumnName = "ID", insertable=true, updatable=true, nullable=true, unique=true)
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private Sketch sketch;
    
    @JsonView(JSonViews.EntityView.class)
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "operation", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Use> use = new ArrayList<>();
    
    @JsonView(JSonViews.EntityView.class)
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "operation", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Consume> consume = new ArrayList<>();

    @JsonView(JSonViews.EntityView.class)
    @JsonSerialize(using = NullCollectionSerializer.class)
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "operation", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Produce> produce = new ArrayList<>();

    /**
     *
     */
    public Operation() {
        this.parentType = Process.class;
    }
    
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("Operation requires a Process instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }

        setProcess((Process) parent);
    }

    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getProcess();
    }
    
    /**
     *
     * @param id
     * @param sequence
     * @param name
     */
    public Operation(long id, int sequence, String name) {
        this.id = id;
        this.sequence = sequence;
        this.name = name;
    }

    /**
     * @return the process
     */
    public Process getProcess() {
        return process;
    }

    /**
     * @param process the process to set
     */
    public void setProcess(Process process) {
        this.process = process;
    }

    /**
     * @return the sequence
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(int sequence) {
        this.sequence = sequence;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the sketch
     */
    public Sketch getSketch() {
        return sketch;
    }

    /**
     * @param sketch the sketch to set
     */
    public void setSketch(Sketch sketch) {
        this.sketch = sketch;
    }

    /**
     * @return the use
     */
    public List<Use> getUse() {
        return use;
    }

    /**
     * @param use the use to set
     */
    public void setUse(List<Use> use) {
        this.use = use;
    }

    /**
     * @return the consume
     */
    public List<Consume> getConsume() {
        return consume;
    }

    /**
     * @param consume the consume to set
     */
    public void setConsume(List<Consume> consume) {
        this.consume = consume;
    }

    /**
     * @return the produce
     */
    public List<Produce> getProduce() {
        return produce;
    }

    /**
     * @param produce the produce to set
     */
    public void setProduce(List<Produce> produce) {
        this.produce = produce;
    }

}
