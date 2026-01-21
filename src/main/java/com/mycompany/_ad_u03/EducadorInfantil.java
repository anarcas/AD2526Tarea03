/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._ad_u03;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author anaranjo
 */
@Entity
@Table(name = "educador_infantil")
@NamedQueries({
    @NamedQuery(name = "EducadorInfantil.findAll", query = "SELECT e FROM EducadorInfantil e"),
    @NamedQuery(name = "EducadorInfantil.findByDni", query = "SELECT e FROM EducadorInfantil e WHERE e.dni = :dni"),
    @NamedQuery(name = "EducadorInfantil.findByNombre", query = "SELECT e FROM EducadorInfantil e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EducadorInfantil.findByApellidos", query = "SELECT e FROM EducadorInfantil e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "EducadorInfantil.findByFechaNacimiento", query = "SELECT e FROM EducadorInfantil e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "EducadorInfantil.findByFechaAlta", query = "SELECT e FROM EducadorInfantil e WHERE e.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "EducadorInfantil.findBySalario", query = "SELECT e FROM EducadorInfantil e WHERE e.salario = :salario")})
public class EducadorInfantil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Float salario;
    @JoinColumn(name = "codigo_guarderia", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Guarderia codigoGuarderia;

    public EducadorInfantil() {
    }

    public EducadorInfantil(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Guarderia getCodigoGuarderia() {
        return codigoGuarderia;
    }

    public void setCodigoGuarderia(Guarderia codigoGuarderia) {
        this.codigoGuarderia = codigoGuarderia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducadorInfantil)) {
            return false;
        }
        EducadorInfantil other = (EducadorInfantil) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany._ad_u03.EducadorInfantil[ dni=" + dni + " ]";
    }
    
}
