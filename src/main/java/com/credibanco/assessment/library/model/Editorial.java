package com.credibanco.assessment.library.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EDITORIALES")
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EDITORIAL_ID")
    private long id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "DIRECCION", nullable = false, length = 200)
    private String direccion;

    @Column(name = "TELEFONO", nullable = false, length = 30)
    private String telefono;

    @Column(name = "EMAIL", length = 200)
    private String email;

    @Column(name = "MAXIMOLIBROS", nullable = false, length = 10)
    private int maximoLibros;
    
    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;

    public Editorial() {
    }

    public Editorial(
            String nombre,
            String direccion,
            String telefono,
            String email,
            int maximoLibros
    ) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.maximoLibros = maximoLibros;
    }

    //SET
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMaximoLibros(int maximoLibros) {
        this.maximoLibros = maximoLibros;
    }

    //GET
    public long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public int getMaximoLibros() {
        return this.maximoLibros;
    }

    public List<Libro> getLibros() {
        return this.libros;
    }
}
