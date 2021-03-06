/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.process;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alessandro
 */
@Entity
@Table(name = "MN_PROCESS_SKETCH")
public class Sketch extends br.com.altamira.data.model.Resource {

    /**
     *
     */
    private static final long serialVersionUID = -9062344996470918309L;

    @JsonIgnore
    @JoinColumn(name = "OPERATION", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Operation operation;

    //@NotNull
    @Column(name = "FILE_TYPE")
    private String format;

    //@NotNull
    @Column(name = "FILE_NAME")
    private String filename;

    //@NotNull
    @Column(name = "FILE_EXT")
    private String extension;

    @Lob
    //@JsonView(JSonViews.LobView.class)
    @Column(name = "FILE_BODY")
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    /**
     *
     */
    public Sketch() {
        this.parentType = Operation.class;
    }

    /**
     *
     * @param parent
     */
    @Override
    public void setParent(br.com.altamira.data.model.Entity parent) {
        /*if (parentType.isInstance(parent)) {
         throw new IllegalArgumentException("Sketch requires a Operation instance object as a parent.");
         }*/

        setOperation((Operation) parent);
    }

    /**
     *
     * @return
     */
    @Override
    public br.com.altamira.data.model.Entity getParent() {
        return getOperation();
    }

    /**
     * @return the type
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @return the name
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     */
    public void setgetFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     *
     * @return
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     *
     * @param operation
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
