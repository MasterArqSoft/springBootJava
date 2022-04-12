package com.credibanco.assessment.library.repository;

import com.credibanco.assessment.library.model.Autor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("AutorRepository")
public interface IAutorRepository extends CrudRepository<Autor, Long> {

    /**
     *
     * @param search
     * @return
     */
    @Query(value = "SELECT * FROM autores l  WHERE l.NOMBRE_COMPLETO=?1", nativeQuery = true)
    public Autor findByAutorName(String search);
}
