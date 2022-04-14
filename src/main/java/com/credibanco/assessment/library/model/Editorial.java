package com.credibanco.assessment.library.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EDITORIALES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_EDITORIAL")
    @SequenceGenerator(
            name = "SEQ_EDITORIAL",
            allocationSize = 1,
            initialValue = 1)
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
}
