package com.credibanco.assessment.library.service;

import com.credibanco.assessment.library.dto.LibroDto;
import java.util.List;

public interface ILibroService {

    public abstract List<LibroDto> getAllLibros();

    public abstract List<LibroDto> getAllLibrosSearch(String search);

    public abstract LibroDto createLibro(LibroDto libroDto);

    public abstract LibroDto updateLibro(long id, LibroDto libroDto);

    public abstract boolean deleteLibro(long id);

    public abstract LibroDto getLibroById(long id);
}
