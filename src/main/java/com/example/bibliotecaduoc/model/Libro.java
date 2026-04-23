package com.example.bibliotecaduoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name= "libros")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 13,nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String editorial;

    @Column(nullable = false)
    private Date fechaPublicacion;

    @Column(nullable = false)
    private String autor;
}








   /* private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor; */