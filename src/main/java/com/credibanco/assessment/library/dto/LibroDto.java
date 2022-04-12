package com.credibanco.assessment.library.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class LibroDto {

    private long id;
    @NotEmpty(message = "El título del libro no puede estar vacío.")
    @Size(min = 2, message = "El título del libro al menos debe contener 2 caractres.")
    private String titulo;
    private int anios;
    @NotEmpty(message = "El género del libro no puede estar vacío.")
    @Size(min = 2, message = "El género del libro al menos debe contener 2 caractres.")
    private String genero;
    @NotNull(message = "El número Paginas del libro es requerido.")
    @Min(value = 1, message = "El número de Paginas del libro al menos debe ser mayor a 0.")
    private int numeroPaginas;
    private String editorial;
    @NotEmpty(message = "El autor del libro no puede estar vacío.")
    @Size(min = 2, message = "El autor del libro al menos debe contener 2 caractres.")
    private String autor;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the anios
     */
    public int getAnios() {
        return anios;
    }

    /**
     * @param anios the anios to set
     */
    public void setAnios(int anios) {
        this.anios = anios;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the numeroPaginas
     */
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    /**
     * @param numeroPaginas the numeroPaginas to set
     */
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
}
