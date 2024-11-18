package com.example.demo.db.orm;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="inventario")
@Entity
@Data
@NoArgsConstructor
public class InventarioORM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="producto_id",nullable = false)
    private ProductoORM producto;
    @Column
    private String descripcion;

}
