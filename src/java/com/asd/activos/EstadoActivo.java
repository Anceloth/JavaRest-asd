/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.activos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author taufiq
 */
@Entity
@Table(name = "estado_activo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoActivo.findAll", query = "SELECT e FROM EstadoActivo e")
    , @NamedQuery(name = "EstadoActivo.findByIdEstado", query = "SELECT e FROM EstadoActivo e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadoActivo.findByNombreEstado", query = "SELECT e FROM EstadoActivo e WHERE e.nombreEstado = :nombreEstado")})
public class EstadoActivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Integer idEstado;
    @Basic(optional = false)
    @Column(name = "nombre_estado")
    private String nombreEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private Collection<ActivosFijos> activosFijosCollection;

    public EstadoActivo() {
    }

    public EstadoActivo(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoActivo(Integer idEstado, String nombreEstado) {
        this.idEstado = idEstado;
        this.nombreEstado = nombreEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @XmlTransient
    public Collection<ActivosFijos> getActivosFijosCollection() {
        return activosFijosCollection;
    }

    public void setActivosFijosCollection(Collection<ActivosFijos> activosFijosCollection) {
        this.activosFijosCollection = activosFijosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoActivo)) {
            return false;
        }
        EstadoActivo other = (EstadoActivo) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.activos.EstadoActivo[ idEstado=" + idEstado + " ]";
    }
    
}
