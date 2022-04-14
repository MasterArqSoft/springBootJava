package com.credibanco.assessment.library.dto;

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
public class LibroDto {

    private long id;
    @NotEmpty(message = "El título del libro no puede estar vacío.")
    @Size(min = 2, message = "El título del libro al menos debe contener 2 caractres.")
    private String titulo;
    private String anios;
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
}
