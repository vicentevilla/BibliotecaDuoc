package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.stereotype.Service;



//ejemplo


@Service
@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listaLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregaLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }
    
    @GetMapping("{id}")
    public Libro buscaLibro(@PathVariable int id) {
        return libroService.getLibroId(id);
    }
    
    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }
    @GetMapping("/total")
    public int totaLibrosV2(){
        return libroService.totaLibrosV2();
    }
    @GetMapping("/isbn/{isbn}")
    public Libro buscaIsbn(@PathVariable String isbn) {
        return libroService.getLibroIsbn(isbn);
    }
    @GetMapping("/autor/{autor}")
    public List<Libro> buscaAutor(@PathVariable String autor){
        return libroService.getLibroAutor(autor);
    }
    @GetMapping("/publi/{publi}")
    public List<Libro> buscaPubli(@PathVariable int publi){
        return libroService.getLibroPubli(publi);
    }
} 
