package com.credibanco.assessment.library.controller;

import com.credibanco.assessment.library.dto.AutorDto;
import com.credibanco.assessment.library.service.impl.AutorService;
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


@RequestMapping("/api/autor")
@RestController
@Validated
public class AutorController {

    @Autowired
    @Qualifier("AutorServiceImpl")
    private final AutorService autorService;

    public AutorController(AutorService Autorservice) {
        super();
        this.autorService = Autorservice;
    }

    @GetMapping(value = "/autores")
    List<AutorDto> getAll() {
        return this.autorService.getAllAutores();
    }

    @GetMapping(value = "/autor/{id}")
    ResponseEntity<AutorDto> getById(@PathVariable("id") @Min(1) long id) {
        
        return ResponseEntity.ok().body(this.autorService.getAutorById(id));
    }

    @PostMapping(value = "/autor")
    ResponseEntity<AutorDto> create(@Valid @RequestBody AutorDto autorDto) {
        return ResponseEntity.ok().body(this.autorService.createAutor(autorDto));
    }

    @PutMapping(value = "/autor/{id}")
    ResponseEntity<AutorDto> update(@PathVariable("id") @Min(1) long id, @Valid @RequestBody AutorDto autorDto) {
        return ResponseEntity.ok().body(this.autorService.updateAutor(id,autorDto));
    }

    @DeleteMapping(value = "/autor/{id}")
    Map<String, Boolean> delete(@PathVariable("id") @Min(1) long id) {
        this.autorService.deleteAutor(id);
        Map <String, Boolean> response = new HashMap <> ();
        response.put("deleted", Boolean.TRUE);
        return response;  
    }
}
