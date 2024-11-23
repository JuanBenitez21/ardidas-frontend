package com.example.demo.db.orm;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name= "productos")
@Entity
@Data
@NoArgsConstructor
public class ProductoORM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private double precio;
    @ManyToOne
    @JoinColumn(name="categoria_id",nullable = false)
    private CategoriaORM categoria;
    @Column
    private int stock;
    @Column
    private String talla;
    @Column
    private String marca;
    @Column
    private String imagen;

    private int NivelMinimo=10;


}
