/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.activos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author taufiq
 */
@Entity
@Table(name = "activos_fijos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivosFijos.findAll", query = "SELECT a FROM ActivosFijos a")
    , @NamedQuery(name = "ActivosFijos.findByNumInternoInventario", query = "SELECT a FROM ActivosFijos a WHERE a.numInternoInventario = :numInternoInventario")
    , @NamedQuery(name = "ActivosFijos.findBySerial", query = "SELECT a FROM ActivosFijos a WHERE a.serial = :serial")
    , @NamedQuery(name = "ActivosFijos.findByTipo", query = "SELECT a FROM ActivosFijos a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "ActivosFijos.findByNombre", query = "SELECT a FROM ActivosFijos a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "ActivosFijos.findByPesoKg", query = "SELECT a FROM ActivosFijos a WHERE a.pesoKg = :pesoKg")
    , @NamedQuery(name = "ActivosFijos.findByAnchoMts", query = "SELECT a FROM ActivosFijos a WHERE a.anchoMts = :anchoMts")
    , @NamedQuery(name = "ActivosFijos.findByAltoMts", query = "SELECT a FROM ActivosFijos a WHERE a.altoMts = :altoMts")
    , @NamedQuery(name = "ActivosFijos.findByLargoMts", query = "SELECT a FROM ActivosFijos a WHERE a.largoMts = :largoMts")
    , @NamedQuery(name = "ActivosFijos.findByValorCompraPesos", query = "SELECT a FROM ActivosFijos a WHERE a.valorCompraPesos = :valorCompraPesos")
    , @NamedQuery(name = "ActivosFijos.findByFechaCompra", query = "SELECT a FROM ActivosFijos a WHERE a.fechaCompra = :fechaCompra")
    , @NamedQuery(name = "ActivosFijos.findByFechaDeBaja", query = "SELECT a FROM ActivosFijos a WHERE a.fechaDeBaja = :fechaDeBaja")
    , @NamedQuery(name = "ActivosFijos.findByColor", query = "SELECT a FROM ActivosFijos a WHERE a.color = :color")})
public class ActivosFijos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_interno_inventario")
    private Integer numInternoInventario;
    @Basic(optional = false)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_kg")
    private Float pesoKg;
    @Column(name = "ancho_mts")
    private Float anchoMts;
    @Column(name = "alto_mts")
    private Float altoMts;
    @Column(name = "largo_mts")
    private Float largoMts;
    @Column(name = "valor_compra_pesos")
    private Float valorCompraPesos;
    @Basic(optional = false)
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Basic(optional = false)
    @Column(name = "fecha_de_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaDeBaja;
    @Column(name = "color")
    private String color;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne
    private Area idArea;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoActivo idEstado;
    @JoinColumn(name = "cedula_persona", referencedColumnName = "cedula")
    @ManyToOne
    private Persona cedulaPersona;

    public ActivosFijos() {
    }

    public ActivosFijos(Integer numInternoInventario) {
        this.numInternoInventario = numInternoInventario;
    }

    public ActivosFijos(Integer numInternoInventario, String serial, String tipo, String nombre, Date fechaCompra, Date fechaDeBaja) {
        this.numInternoInventario = numInternoInventario;
        this.serial = serial;
        this.tipo = tipo;
        this.nombre = nombre;
        this.fechaCompra = fechaCompra;
        this.fechaDeBaja = fechaDeBaja;
    }

    public Integer getNumInternoInventario() {
        return numInternoInventario;
    }

    public void setNumInternoInventario(Integer numInternoInventario) {
        this.numInternoInventario = numInternoInventario;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(Float pesoKg) {
        this.pesoKg = pesoKg;
    }

    public Float getAnchoMts() {
        return anchoMts;
    }

    public void setAnchoMts(Float anchoMts) {
        this.anchoMts = anchoMts;
    }

    public Float getAltoMts() {
        return altoMts;
    }

    public void setAltoMts(Float altoMts) {
        this.altoMts = altoMts;
    }

    public Float getLargoMts() {
        return largoMts;
    }

    public void setLargoMts(Float largoMts) {
        this.largoMts = largoMts;
    }

    public Float getValorCompraPesos() {
        return valorCompraPesos;
    }

    public void setValorCompraPesos(Float valorCompraPesos) {
        this.valorCompraPesos = valorCompraPesos;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(Date fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public EstadoActivo getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoActivo idEstado) {
        this.idEstado = idEstado;
    }

    public Persona getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(Persona cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numInternoInventario != null ? numInternoInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivosFijos)) {
            return false;
        }
        ActivosFijos other = (ActivosFijos) object;
        if ((this.numInternoInventario == null && other.numInternoInventario != null) || (this.numInternoInventario != null && !this.numInternoInventario.equals(other.numInternoInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.activos.ActivosFijos[ numInternoInventario=" + numInternoInventario + " ]";
    }
    
}
