package com.example.demo.db.orm;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="detalles_ordenes")
@Entity
@Data
@NoArgsConstructor
public class OrdenORM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoORM producto;


    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private Double precio;

}
