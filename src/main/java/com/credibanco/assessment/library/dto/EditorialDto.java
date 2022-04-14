package com.credibanco.assessment.library.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
