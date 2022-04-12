package com.credibanco.assessment.library.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AUTORES")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AUTOR_ID")
    private long id;
    
    @Column(name = "NOMBRE_COMPLETO", nullable = false, length = 200)
    private String nombreCompleto;
    
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Column(name = "CIUDAD_PROCEDENCIA", length = 200)
    private String ciudadProcedencia;
    
    @Column(name = "EMAIL", length = 200)
    private String email;
    
    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(
            String nombreCompleto,
            Date fechaNacimiento,
            String ciudadProcedencia,
            String email
    ) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadProcedencia = ciudadProcedencia;
        this.email = email;
    }

    //SET
    public void setId(long id) {
        this.id = id;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCiudadProcedencia(String ciudadProcedencia) {
        this.ciudadProcedencia = ciudadProcedencia;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setCourses(List<Libro> libros) {
        this.libros = libros;
    }

    //GET
    public long getId() {
        return this.id;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public String getCiudadProcedencia() {
        return this.ciudadProcedencia;
    }

    public String getEmail() {
        return this.email;
    }
    
    public List<Libro> getLibros() {
        return this.libros;
    }
}
