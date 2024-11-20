package com.example.demo.controller.dto;

import java.time.LocalDate;

public record OrdenDTO(Long producto, LocalDate fecha, int Cantidad, Double precio ) {
}
