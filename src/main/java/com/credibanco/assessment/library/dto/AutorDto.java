package com.credibanco.assessment.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorDto {

    private long id;
    @NotNull(message = "El nombre del autor es requerido.")
    @NotEmpty(message = "El nombre del autor no puede estar vacío.")
    @Size(min = 2, message = "El nombre del autor al menos debe contener 2 caractres.")
    private String nombreCompleto;
    @Past(message = "La fecha de nacimiento debe ser menor al actua.l")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    private String ciudadProcedencia;
    @Email(message = "El correo electrónico es invalido.")
    private String email;
}
