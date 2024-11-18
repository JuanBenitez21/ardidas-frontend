package com.example.demo.controller.dto;

import com.example.demo.controller.logica.OrdenService;
import com.example.demo.db.orm.OrdenORM;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class OrdenController {

    private OrdenService ordenService;

    @PostMapping(path="/registrar")
    public String guardarOrden(@RequestBody OrdenDTO ordenDTO){
        ordenService.guardarOrden(ordenDTO.producto(), ordenDTO.Cantidad());
        return "Venta registrada";
    }

    @GetMapping(path= "/ventas")
    public List<OrdenORM> consultarOrdenesPorDia(@RequestParam String fecha){
        LocalDate fechaVenta = LocalDate.parse(fecha);
        log.info("Fecha de venta: " + fechaVenta);
        return ordenService.consultarOrden(fechaVenta);
    }
}
