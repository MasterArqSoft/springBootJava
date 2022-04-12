package com.credibanco.assessment.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "LIBROS")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "TITULO", nullable = false, length = 200)
    private String titulo;

    @Column(name = "ANIOS", length = 10)
    private int anios;

    @Column(name = "GENERO", nullable = false, length = 200)
    private String genero;

    @Column(name = "NUMEROPAGINAS", nullable = false, length = 10)
    private int numeroPaginas;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "EDITORIAL_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Editorial editorial;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "AUTOR_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Autor autor;

    public Libro() {
    }

    public Libro(
            String titulo,
            int anios,
            String genero,
            int numeroPaginas,
            Editorial editorial,
            Autor autor
    ) {
        this.titulo = titulo;
        this.anios = anios;
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.autor = autor;
    }

    //SET
    public void setId(long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    //GET
    public long getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getAnios() {
        return this.anios;
    }

    public String getGenero() {
        return this.genero;
    }

    public int getNumeroPaginas() {
        return this.numeroPaginas;
    }

    public Editorial getEditorial() {
        return editorial;
    }
    public Autor getAutor() {
        return this.autor;
    }
}
