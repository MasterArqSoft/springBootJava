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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "LIBROS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libro implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_LIBRO")
    @SequenceGenerator(
            name = "SEQ_LIBRO",
            allocationSize = 1,
            initialValue = 1)
    @Column(name = "LIBRO_ID")
    private long id;

    @Column(name = "TITULO", nullable = false, length = 200)
    private String titulo;

    @Column(name = "ANIOS", length = 10)
    private String anios;

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
}
