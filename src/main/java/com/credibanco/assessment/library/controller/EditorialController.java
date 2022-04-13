package com.credibanco.assessment.library.controller;

import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.service.impl.EditorialService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/editorial")
@RestController
@Validated
public class EditorialController {

    @Autowired
    @Qualifier("EditorialServiceImpl")
    private final EditorialService editorialService;

    public EditorialController(EditorialService Editorialservice) {
        super();
        this.editorialService = Editorialservice;
    }
    
    
    @GetMapping(value = "/editoriales")
    List<EditorialDto> getAll() {
        return this.editorialService.getAllEditoriales();
    }

    @GetMapping(value = "/editorial/{id}")
    ResponseEntity<EditorialDto> getById(@PathVariable("id") @Min(1) long id) {
        
        return ResponseEntity.ok().body(this.editorialService.getEditorialById(id));
    }

    @PostMapping(value = "/editorial")
    ResponseEntity<EditorialDto> create(@Valid @RequestBody EditorialDto editorialDto) {
        return ResponseEntity.ok().body(this.editorialService.createEditorial(editorialDto));
    }

    @PutMapping(value = "/editorial/{id}")
    ResponseEntity<EditorialDto> update(@PathVariable("id") @Min(1) long id, @Valid @RequestBody EditorialDto editorialDto) {
        return ResponseEntity.ok().body(this.editorialService.updateEditorial(id,editorialDto));
    }

    @DeleteMapping(value = "/editorial/{id}")
    Map<String, Boolean> delete(@PathVariable("id") @Min(1) long id) {
        this.editorialService.deleteEditorial(id);
        Map <String, Boolean> response = new HashMap <> ();
        response.put("deleted", Boolean.TRUE);
        return response;  
    }
    
}
