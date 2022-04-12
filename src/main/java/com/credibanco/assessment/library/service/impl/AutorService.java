package com.credibanco.assessment.library.service.impl;

import com.credibanco.assessment.library.dto.AutorDto;
import com.credibanco.assessment.library.exceptions.ResourceNotFoundException;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.repository.IAutorRepository;
import com.credibanco.assessment.library.service.IAutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("AutorServiceImpl")
@Transactional()
public class AutorService implements IAutorService {

    @Autowired
    private ModelMapper modelMapper;
    @Qualifier("AutorRepository")
    @Autowired
    private IAutorRepository autorRepository;

    @Override
    public List<AutorDto> getAllAutores() {
        List<AutorDto> autorDtos = new ArrayList<>();
        List<Autor> autores = (List<Autor>) autorRepository.findAll();
        if (autores.isEmpty()) {
            throw new ResourceNotFoundException("No hay resgistros de autores");
        }
        autorRepository.findAll().forEach(autor -> autorDtos.add(modelMapper.map(autor, AutorDto.class)));
        return autorDtos;
    }

    @Override
    public AutorDto getAutorById(long id) {
        Autor autorRequest = (Autor)autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor con ID:" + id + " No encontrado."));
        
        AutorDto autorResponse = modelMapper.map(autorRequest, AutorDto.class);
        return autorResponse;
    }

    @Override
    public AutorDto createAutor(AutorDto autorDto) {
        Autor autorRequest = modelMapper.map(autorDto, Autor.class);
        Autor autor = autorRepository.save(autorRequest);
        AutorDto postResponse = modelMapper.map(autor, AutorDto.class);
        return postResponse;
    }

    @Override
    public AutorDto updateAutor(long id, AutorDto autorDto) {

        Autor autorRequest = autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor con ID:" + id + " No encontrado."));

        autorRequest.setNombreCompleto(autorDto.getNombreCompleto());
        autorRequest.setFechaNacimiento(autorDto.getFechaNacimiento());
        autorRequest.setCiudadProcedencia(autorDto.getCiudadProcedencia());
        autorRequest.setEmail(autorDto.getEmail());

        Autor autor = autorRepository.save(autorRequest);
        AutorDto autorResponse = modelMapper.map(autor, AutorDto.class);

        return autorResponse;
    }

    @Override
    public boolean deleteAutor(long id) {
        Autor autorRequest = autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor con ID:" + id + " No encontrado."));

        autorRepository.delete(autorRequest);

        return true;
    }

}
