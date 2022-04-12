package com.credibanco.assessment.library.service.impl;

import com.credibanco.assessment.library.dto.LibroDto;
import com.credibanco.assessment.library.exceptions.ResourceNotFoundException;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.model.Libro;
import com.credibanco.assessment.library.repository.IAutorRepository;
import com.credibanco.assessment.library.repository.IEditorialRepository;
import com.credibanco.assessment.library.repository.ILibroRepository;
import com.credibanco.assessment.library.service.ILibroService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("LibroServiceImpl")
@Transactional()
public class LibroService implements ILibroService {

    @Autowired
    private ModelMapper modelMapper;
    @Qualifier("LibroRepository")
    @Autowired
    private ILibroRepository libroRepository;
    @Qualifier("EditorialRepository")
    @Autowired
    private IEditorialRepository editorialRepository;
    @Qualifier("AutorRepository")
    @Autowired
    private IAutorRepository autorRepository;

    @Override
    public List<LibroDto> getAllLibros() {
        List<LibroDto> libroDtos = new ArrayList<>();
        List<Libro> libros = (List<Libro>) libroRepository.findAll();
        if (libros.isEmpty()) {
            throw new ResourceNotFoundException("No hay resgistros de libros");
        }
        libroRepository.findAll().forEach(libro -> libroDtos.add(convertEntityToDto(libro)));
        return libroDtos;
    }

    @Override
    public List<LibroDto> getAllLibrosSearch(String search) {
        List<LibroDto> libroDtos = new ArrayList<>();
        if (search.isEmpty()) {
            return this.getAllLibros();
        }
        List<Libro> libros = (List<Libro>) libroRepository.findByTituloAutorAnio(search);
        if (libros.isEmpty()) {
            throw new ResourceNotFoundException("El libro buscado por " + search + " no existe algun registro.");
        }
        libroRepository.findByTituloAutorAnio(search).forEach(libro -> libroDtos.add(convertEntityToDto(libro)));
        return libroDtos;
    }

    @Override
    public LibroDto getLibroById(long id) {
        Libro libroRequest = (Libro)libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro con ID:" + id + " No encontrado."));
        LibroDto libroResponse = convertEntityToDto(libroRequest);
        return libroResponse;
    }
    
    
    @Override
    public LibroDto createLibro(LibroDto libroDto) {

        Autor autorExiste = autorRepository.findByAutorName(libroDto.getAutor());
        if (autorExiste == null) {
            throw new ResourceNotFoundException("El autor(a) " + libroDto.getAutor() + " del libro no encontrado(a).");
        }

        Editorial editorialExiste = editorialRepository.findByEditorialName(libroDto.getEditorial());
        if (editorialExiste == null) {
            throw new ResourceNotFoundException("La Editorial " + libroDto.getEditorial() + " del libro no encontrada.");
        }

        if (!(editorialExiste.getMaximoLibros() + 1 > editorialExiste.getMaximoLibros()) && -1 != editorialExiste.getMaximoLibros()) {
            throw new ResourceNotFoundException("El libro supera el maximno permitido por una editorial Editorial.");
        }

        Libro libroRequest = modelMapper.map(libroDto, Libro.class);
        libroRequest.setAutor(autorExiste);
        libroRequest.setEditorial(editorialExiste);
        Libro libro = libroRepository.save(libroRequest);
        LibroDto libroResponse = this.convertEntityToDto(libro);
        return libroResponse;
    }

    @Override
    public LibroDto updateLibro(long id, LibroDto libroDto) {

        Libro libroRequest = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro con ID:" + id + " No encontrado."));
      
        Autor autorExiste = autorRepository.findByAutorName(libroDto.getAutor());
        if (autorExiste == null) {
            throw new ResourceNotFoundException("El autor(a) " + libroDto.getAutor() + " del libro no encontrado(a).");
        }

        Editorial editorialExiste = editorialRepository.findByEditorialName(libroDto.getEditorial());
        if (editorialExiste == null) {
            throw new ResourceNotFoundException("La Editorial " + libroDto.getEditorial() + " del libro no encontrada.");
        }

        if (!(editorialExiste.getMaximoLibros() + 1 > editorialExiste.getMaximoLibros()) && -1 != editorialExiste.getMaximoLibros()) {
            throw new ResourceNotFoundException("El libro supera el maximno permitido por una editorial Editorial.");
        }
        libroRequest.setTitulo(libroDto.getTitulo());
        libroRequest.setAnios(libroDto.getAnios());
        libroRequest.setGenero(libroDto.getGenero());
        libroRequest.setNumeroPaginas(libroDto.getNumeroPaginas());
        libroRequest.setEditorial(editorialExiste);
        libroRequest.setAutor(autorExiste);

        Libro libro = libroRepository.save(libroRequest);
        LibroDto liborResponse =this.convertEntityToDto(libro);

        return liborResponse;
    }

    @Override
    public boolean deleteLibro(long id) {
        Libro libroRequest = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro con ID:" + id + " No encontrado."));

        libroRepository.delete(libroRequest);

        return true;
    }
    
    private LibroDto convertEntityToDto(Libro libro){
      LibroDto libroDto =  modelMapper.map(libro, LibroDto.class);
      libroDto.setEditorial(libro.getEditorial().getNombre());
      libroDto.setAutor(libro.getAutor().getNombreCompleto());
      return libroDto;
    }
}
