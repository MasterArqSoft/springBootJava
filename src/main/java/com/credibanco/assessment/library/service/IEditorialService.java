package com.credibanco.assessment.library.service;

import com.credibanco.assessment.library.dto.EditorialDto;
import java.util.List;

public interface IEditorialService {

    public abstract List<EditorialDto> getAllEditoriales();

    public abstract EditorialDto createEditorial(EditorialDto editorialDto);

    public abstract EditorialDto updateEditorial(long id, EditorialDto editorialDto);

    public abstract boolean deleteEditorial(long id);

    public abstract EditorialDto getEditorialById(long id);
}
