package com.credibanco.assessment.library.service.impl;

import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.exceptions.ResourceNotFoundException;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.repository.IEditorialRepository;
import com.credibanco.assessment.library.service.IEditorialService;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("EditorialServiceImpl")
@Transactional()
public class EditorialService implements IEditorialService {

    @Autowired
    private ModelMapper modelMapper;
    @Qualifier("EditorialRepository")
    @Autowired
    private IEditorialRepository editorialRepository;

    @Override
    public List<EditorialDto> getAllEditoriales() {
        List<Editorial> editoriales = (List<Editorial>) editorialRepository.findAll();
        if (editoriales.isEmpty()) {
            throw new ResourceNotFoundException("No hay resgistros de editoriales");
        }
         List<EditorialDto> editorialDtos = editoriales.stream().map(editorial -> modelMapper.map(editorial, EditorialDto.class))
                                   .collect(Collectors.toList());
        return editorialDtos;
    }

    @Override
    public EditorialDto getEditorialById(long id) {
        Editorial editorialRequest = (Editorial) editorialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Editorial con ID:" + id + " No encontrado."));
        EditorialDto editorialResponse = modelMapper.map(editorialRequest, EditorialDto.class);
        return editorialResponse;
    }

    @Override
    public EditorialDto createEditorial(EditorialDto editorialDto) {
        Editorial editorialRequest = modelMapper.map(editorialDto, Editorial.class);
        editorialRequest.setMaximoLibros(editorialDto.getMaximoLibros() == 0 ? -1 : editorialDto.getMaximoLibros());
        Editorial editorial = editorialRepository.save(editorialRequest);
        EditorialDto postResponse = modelMapper.map(editorial, EditorialDto.class);
        return postResponse;
    }

    @Override
    public EditorialDto updateEditorial(long id, EditorialDto editorialDto) {

        Editorial editorialRequest = editorialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Editorial con ID:" + id + " No encontrado."));

        editorialRequest.setNombre(editorialDto.getNombre());
        editorialRequest.setDireccion(editorialDto.getDireccion());
        editorialRequest.setTelefono(editorialDto.getTelefono());
        editorialRequest.setEmail(editorialDto.getEmail());
        editorialRequest.setMaximoLibros(editorialDto.getMaximoLibros() == 0 ? -1 : editorialDto.getMaximoLibros());

        Editorial editorial = editorialRepository.save(editorialRequest);
        EditorialDto editorialResponse = modelMapper.map(editorial, EditorialDto.class);

        return editorialResponse;
    }

    @Override
    public boolean deleteEditorial(long id) {
        Editorial editorialRequest = editorialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Editorial con ID:" + id + " No encontrado."));

        editorialRepository.delete(editorialRequest);

        return true;
    }

}
