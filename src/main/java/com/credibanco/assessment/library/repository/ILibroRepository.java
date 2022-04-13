package com.credibanco.assessment.library.repository;

import com.credibanco.assessment.library.model.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("LibroRepository")
public interface ILibroRepository extends CrudRepository<Libro, Long> {

    /**
     *
     *
     * @param search
     * @return
     */
    @Query(value = """
                   SELECT * FROM libros l 
                   INNER JOIN autores au ON l.autor_id = au.autor_id
                   WHERE au.nombre_completo =?1 or l.titulo=?1 or l.anios=?1 """, nativeQuery = true)
    public List<Libro> findByTituloAutorAnio(String search);
}
