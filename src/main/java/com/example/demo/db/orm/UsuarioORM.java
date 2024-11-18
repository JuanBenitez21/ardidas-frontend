package com.example.demo.db.orm;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="usuarios")
@Entity
@Data
@NoArgsConstructor
public class UsuarioORM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Column
    private String direccion;

    @Column
    private String telefono;

    public enum TipoUsuario {
        CLIENTE,
        ADMINISTRADOR
    }
}
