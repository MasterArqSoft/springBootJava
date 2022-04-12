package com.credibanco.assessment.library.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class EditorialDto {

    private long id;
    @NotNull(message = "El nombre de la editorial es requerido.")
    @NotEmpty(message = "El nombre de la editorial no puede estar vacío.")
    @Size(min = 2, message = "El nombre de la editorial al menos debe contener 2 caractres.")
    private String nombre;
    @NotNull(message = "la dirección de la editorial es requerido.")
    @NotEmpty(message="La dirección de la editorial no puede estar vacío.")
    @Size(min=2, message="La dirección de la editorial al menos debe contener 2 caractres.")
    private String direccion;
    @NotNull(message = "El teléfono de la editorial  es requerido.")
    @NotEmpty(message="El teléfono de la editorial no puede estar vacío.")
    @Size(min=2, message="El teléfono de la editorial al menos debe contener 2 caractres.")
    private String telefono;
    @Email(message="El correo electrónico es invalido")
    private String email;
    @NotNull(message = "El número maximo de libro de la editorial es requerido.")
    @Min(value=0, message="El número mínimo de libro que se puede digitar es 0.")
    private int maximoLibros;

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the maximoLibros
     */
    public int getMaximoLibros() {
        return maximoLibros;
    }

    /**
     * @param maximoLibros the maximoLibros to set
     */
    public void setMaximoLibros(int maximoLibros) {
        this.maximoLibros = maximoLibros;
    }
}
