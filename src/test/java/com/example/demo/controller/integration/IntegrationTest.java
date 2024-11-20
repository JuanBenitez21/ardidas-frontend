package com.example.demo.controller.integration;

import com.example.demo.controller.dto.OrdenDTO;
import com.example.demo.controller.dto.ProductoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void TestProductoController() {
        ProductoDTO nuevoProducto = new ProductoDTO("Giorno","Giovanna",5000,1L,10,"XS","Passione" );
        ResponseEntity<String> respuesta = restTemplate.postForEntity("/producto",nuevoProducto, String.class);
        System.out.println(respuesta);
        Assertions.assertEquals(HttpStatus.CREATED, respuesta.getBody());
        ResponseEntity<List> resultado = restTemplate.getForEntity("/mercancia", List.class);
        Assertions.assertFalse(Objects.requireNonNull(resultado.getBody()).isEmpty());
        Assertions.assertTrue(resultado.getStatusCode().is2xxSuccessful());

    }

    @Test
    void TestOrdenController() {
        OrdenDTO nuevaOrden = new OrdenDTO(1L, LocalDate.now(),10, 3000.0);
        ResponseEntity<String> respuestaInsercion = restTemplate.postForEntity("/registrar", nuevaOrden, String.class);
        System.out.println(respuestaInsercion);
        Assertions.assertEquals("Orden guardada", respuestaInsercion.getBody());
        ResponseEntity<List> resultado = restTemplate.getForEntity("/ventas?fecha=2024-05-25", List.class);
        Assertions.assertFalse(Objects.requireNonNull(resultado.getBody()).isEmpty());
        Assertions.assertTrue(resultado.getStatusCode().is2xxSuccessful());

    }
}
