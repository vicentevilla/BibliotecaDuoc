package com.example.bibliotecaduoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.services.LibroService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listar(){
        List<Libro> libro = libroService.finAll();
        if (libro.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public ResponseEntity<Libro> guardar(@RequestBody Libro libro){
        Libro libroNuevo = libroService.save(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscar(@PathVariable Integer id){
        try {
            Libro libro = libroService.findById(id);
            return ResponseEntity.ok(libro);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Integer id, @RequestBody Libro libro){
        try {
            Libro lic = libroService.findById(id);
            lic.setId(id);
            lic.setIsbn(libro.getIsbn());
            lic.setTitulo(libro.getTitulo());
            lic.setEditorial(libro.getEditorial());
            lic.setFechaPublicacion(libro.getFechaPublicacion());
            lic.setAutor(libro.getAutor());

            libroService.save(lic);
            return ResponseEntity.ok(libro);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            libroService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}