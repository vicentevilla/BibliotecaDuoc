package com.example.bibliotecaduoc.services;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> finAll(){
        return libroRepository.findAll();
    }

    public Libro findById(long id){
        return libroRepository.findById(id).get();
    }

    public Libro save(Libro libro){
        return libroRepository.save(libro);
    }

    public void delete(Long id){
        libroRepository.deleteById(id);
    }
}
