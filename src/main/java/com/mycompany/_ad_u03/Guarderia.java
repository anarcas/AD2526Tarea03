/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._ad_u03;

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

/**
 *
 * @author anaranjo
 */
@Entity
@Table(name = "guarderia")
@NamedQueries({
    @NamedQuery(name = "Guarderia.findAll", query = "SELECT g FROM Guarderia g"),
    @NamedQuery(name = "Guarderia.findByCodigo", query = "SELECT g FROM Guarderia g WHERE g.codigo = :codigo"),
    @NamedQuery(name = "Guarderia.findByNombre", query = "SELECT g FROM Guarderia g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Guarderia.findByCapacidad", query = "SELECT g FROM Guarderia g WHERE g.capacidad = :capacidad"),
    @NamedQuery(name = "Guarderia.findByPresupuesto", query = "SELECT g FROM Guarderia g WHERE g.presupuesto = :presupuesto")})
public class Guarderia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "capacidad")
    private Integer capacidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "presupuesto")
    private Float presupuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoGuarderia")
    private Collection<EducadorInfantil> educadorInfantilCollection;

    public Guarderia() {
    }

    public Guarderia(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Collection<EducadorInfantil> getEducadorInfantilCollection() {
        return educadorInfantilCollection;
    }

    public void setEducadorInfantilCollection(Collection<EducadorInfantil> educadorInfantilCollection) {
        this.educadorInfantilCollection = educadorInfantilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guarderia)) {
            return false;
        }
        Guarderia other = (Guarderia) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany._ad_u03.Guarderia[ codigo=" + codigo + " ]";
    }
    
}
