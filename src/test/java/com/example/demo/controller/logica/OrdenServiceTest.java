package com.example.demo.controller.logica;

import com.example.demo.db.jpa.OrdenJPA;
import com.example.demo.db.jpa.ProductoJPA;
import com.example.demo.db.orm.OrdenORM;
import com.example.demo.db.orm.ProductoORM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class OrdenServiceTest {

    @Mock
    OrdenJPA ordenJPA;
    @Mock
    ProductoJPA productoJPA;

    @InjectMocks
    OrdenService service;

    @Test
    void Given_ExisteElProducto_When_GuardarOrden(){
        ProductoORM producto = new ProductoORM();
        producto.setId(1L);
        producto.setStock(10);

        OrdenORM ordenSimulada = new OrdenORM();
        ordenSimulada.setId(1L);
        ordenSimulada.setProducto(producto);
        ordenSimulada.setCantidad(2);
        ordenSimulada.setFecha(LocalDate.now());
        Mockito.when(productoJPA.findById(1L)).thenReturn(Optional.of(producto));
        Mockito.when(ordenJPA.save(Mockito.any())).thenReturn(ordenSimulada);

        OrdenORM orden = service.guardarOrden(producto.getId(),ordenSimulada.getCantidad());

        Assertions.assertNotNull(orden);
        Assertions.assertEquals(orden.getId(),ordenSimulada.getId());
        Mockito.verify(ordenJPA, Mockito.times(1)).save(ordenSimulada);
        Mockito.verify(ordenJPA).save(Mockito.any());
    }

    @Test
    void Given_NoExisteElProducto_When_GuardarOrden_Then_ThrowRuntimeException(){
        Long categoriaId = 1L;
        Mockito.when(productoJPA.findById(categoriaId)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class,
                ()->service.guardarOrden(categoriaId,1)
        );
        Mockito.verify(productoJPA, Mockito.times(1)).findById(categoriaId);
        Mockito.verify(ordenJPA, Mockito.times(0)).save(Mockito.any());

    }

    @Test
    void Given_CantidadInvalida_When_GuardarOrden_Then_ThrowRuntimeException(){
        ProductoORM producto = new ProductoORM();
        producto.setId(1L);
        producto.setStock(5);

        Mockito.when(productoJPA.findById(1L)).thenReturn(Optional.of(producto));
        Assertions.assertThrows(RuntimeException.class,
                () ->{service.guardarOrden(producto.getId(),10);}
        );
        Mockito.verify(productoJPA, Mockito.times(1)).findById(1L);
        Mockito.verify(ordenJPA, Mockito.times(0)).save(Mockito.any());
    }

    @Test
    void Given_ExisteFecha_When_ConsultarOrden_Then_ReturnLista(){
        ArrayList<OrdenORM> ordenesSimuladas = new ArrayList<>();
        ordenesSimuladas.add(new OrdenORM());
        LocalDate fecha = LocalDate.of(2024,5,25);
        Mockito.when(ordenJPA.findByFecha(fecha)).thenReturn(ordenesSimuladas);

        List<OrdenORM> ordenes = service.consultarOrden(fecha);

        Assertions.assertEquals(1, ordenes.size());
        Assertions.assertFalse(ordenes.isEmpty());
        Mockito.verify(ordenJPA).findByFecha(fecha);
    }

    @Test
    void Given_NoExisteFecha_When_ConsultarOrden_Then_ThrowRuntimeException(){
        LocalDate fecha = LocalDate.of(2024,5,25);
        Mockito.when(ordenJPA.findByFecha(fecha)).thenReturn(new ArrayList<>());
        Assertions.assertThrows(RuntimeException.class,
                ()->{service.consultarOrden(fecha);}
        );
    }

    @Test
    void When_CalcularPrecioOrden_Then_ReturnPrecio(){
        double precio = 300;
        double resultado = service.calcularPrecioOrden(precio,10);
        Assertions.assertEquals(3000,resultado);
    }
}