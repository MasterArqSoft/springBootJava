package com.credibanco.assessment.library.controller;

import com.credibanco.assessment.library.dto.LibroDto;
import com.credibanco.assessment.library.service.impl.LibroService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/api/libro")
@Validated
public class LibroController {

    @Autowired
    @Qualifier("LibroServiceImpl")
    private final LibroService libroService;

    public LibroController(LibroService Libroservice) {
        super();
        this.libroService = Libroservice;
    }

    @GetMapping(value = "/libros")
    List<LibroDto> getAll() {
        return this.libroService.getAllLibros();
    }

    @GetMapping(value = "/libros/{search}")
   List<LibroDto> getAllSearch(@PathVariable("search") @Valid @Size(min = 2) String search) {
        return this.libroService.getAllLibrosSearch(search);
    }

    @GetMapping(value = "/libro/{id}")
    ResponseEntity<LibroDto> getById(@PathVariable("id") @Min(1) long id) {

        return ResponseEntity.ok().body(this.libroService.getLibroById(id));
    }

    @PostMapping(value = "/libro")
    ResponseEntity<LibroDto> create(@Valid @RequestBody LibroDto libroDto) {
        return ResponseEntity.ok().body(this.libroService.createLibro(libroDto));
    }

    @PutMapping(value = "/libro/{id}")
    ResponseEntity<LibroDto> update(@PathVariable("id") @Min(1) long id, @Valid @RequestBody LibroDto libroDto) {
        return ResponseEntity.ok().body(this.libroService.updateLibro(id, libroDto));
    }
    
    @DeleteMapping(value = "/libro/{id}")
    Map<String, Boolean> delete(@PathVariable("id") @Min(1) long id) {
       this.libroService.deleteLibro(id);
       Map <String, Boolean> response = new HashMap <> ();
       response.put("deleted", Boolean.TRUE);
       return response;
    }
}
