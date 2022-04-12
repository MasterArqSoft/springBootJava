package com.credibanco.assessment.library.repository;

import com.credibanco.assessment.library.model.Editorial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("EditorialRepository")
public interface IEditorialRepository extends CrudRepository<Editorial, Long>    {
        /**
     *
     * @param search
     * @return
     */
    @Query(value = "SELECT * FROM editoriales l  WHERE l.NOMBRE=?1", nativeQuery = true)
    public Editorial findByEditorialName(String search);
}
