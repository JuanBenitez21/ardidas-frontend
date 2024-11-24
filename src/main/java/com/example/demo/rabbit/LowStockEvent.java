package com.example.demo.rabbit;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LowStockEvent {
    private Long id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private int nivelMinimo;
    private LocalDate fecha;
}
