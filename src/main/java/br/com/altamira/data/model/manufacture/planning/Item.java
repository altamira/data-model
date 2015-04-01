package br.com.altamira.data.model.manufacture.planning;

import br.com.altamira.data.model.Resource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Lob;
import javax.persistence.UniqueConstraint;

/**
 *
 * Represents a sales bom item
 */
@Entity(name = "br.com.altamira.data.model.manufacture.planning.Item")
@Table(name = "MN_BOM_ITEM", uniqueConstraints = @UniqueConstraint(columnNames = {"BOM", "ITEM"}))
public class Item extends Resource {

    /**
     * Serial version ID
     */
    private static final long serialVersionUID = 7448803904699786256L;
    
    @JsonIgnore
    @JoinColumn(name = "BOM", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BOM bom = new BOM();

    @NotNull
    @Min(1)
    @Column(name = "ITEM")
    private int item = 0;

    @NotNull
    @Lob
    @Column(name = "DESCRIPTION", length = 100000)
    private String description = "";

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM", insertable=false, updatable=false)
    private Set<Component> component = new HashSet<>();

    /**
     *
     */
    public Item() {
        this.parentType = BOM.class;
    }
    
    /**
     * 
     * @param id
     * @param item
     * @param description
     */
    public Item(Long id, int item, String description) {
        this.id = id;
        this.item = item;
        this.description = description;
    }
        
    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        if (!parentType.isInstance(parent)) {
            throw new IllegalArgumentException("Item requires a BOM instance object as a parent. You try to assign " + parent.getClass() + " as a parent.");
        }
     
        setBOM((BOM)parent);
    }
    
    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getBOM();
    }
    
    /**
     *
     * @return
     */
    @JsonIgnore
    public BOM getBOM() {
        return bom;
    }

    /**
     *
     * @param bom
     */
    @JsonIgnore
    public void setBOM(BOM bom) {
        this.bom = bom;
    }

    /**
     *
     * @return
     */
    public int getItem() {
        return item;
    }

    /**
     *
     * @param item
     */
    public void setItem(int item) {
        this.item = item;
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
    public Set<Component> getComponent() {
        return component;
    }

    /**
     *
     * @param component
     */
    public void setComponent(HashSet<Component> component) {
        this.component = component;
    }

}
