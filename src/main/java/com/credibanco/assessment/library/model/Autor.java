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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AUTORES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_AUTOR")
    @SequenceGenerator(
            name = "SEQ_AUTOR",
            allocationSize = 1,
            initialValue = 1)
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
}
