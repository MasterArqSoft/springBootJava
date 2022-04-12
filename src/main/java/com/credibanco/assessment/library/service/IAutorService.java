package com.credibanco.assessment.library.service;

import com.credibanco.assessment.library.dto.AutorDto;
import java.util.List;

public interface IAutorService {
    	public abstract List<AutorDto> getAllAutores();

	public abstract AutorDto createAutor(AutorDto autorDto);

	public abstract AutorDto updateAutor(long id, AutorDto autorDto);

	public abstract boolean deleteAutor(long id);

	public abstract AutorDto getAutorById(long id);
}
