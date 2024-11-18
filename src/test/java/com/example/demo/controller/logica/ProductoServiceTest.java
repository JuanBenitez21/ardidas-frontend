package com.example.demo.controller.logica;

import com.example.demo.db.jpa.CategoriaJPA;
import com.example.demo.db.jpa.ProductoJPA;
import com.example.demo.db.orm.CategoriaORM;
import com.example.demo.db.orm.ProductoORM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    ProductoJPA productoJPA;
    @Mock
    CategoriaJPA categoriaJPA;

    @InjectMocks
    ProductoService service;


    @Test
    void Given_ExisteLaCategoria_When_GuardarProducto() {
       CategoriaORM categoria = new CategoriaORM();
       categoria.setId(1);
       categoria.setNombre("Test");
       categoria.setDescripcion("Test");
       ProductoORM productoSimulado = new ProductoORM();
       productoSimulado.setNombre("Test");
       productoSimulado.setDescripcion("Test");
       productoSimulado.setPrecio(10);
       productoSimulado.setCategoria(categoria);
       productoSimulado.setStock(10);
       productoSimulado.setTalla("a");
       productoSimulado.setMarca("Test");
       Mockito.when(categoriaJPA.findById(1L)).thenReturn(Optional.of(categoria));
       Mockito.when(productoJPA.save(Mockito.any())).thenReturn(productoSimulado);

       ProductoORM producto = service.guardarProducto(productoSimulado.getNombre(), productoSimulado.getDescripcion(), productoSimulado.getPrecio(), categoria.getId(), productoSimulado.getStock(), productoSimulado.getTalla(), productoSimulado.getMarca());

       Assertions.assertNotNull(producto);
       Assertions.assertEquals(producto.getNombre(), productoSimulado.getNombre());
       Mockito.verify(productoJPA, Mockito.times(1)).save(productoSimulado);
       Mockito.verify(productoJPA).save(Mockito.any());
    }

    @Test
    void Given_NoExisteLaCategoria_WhenGuardarProducto_Then_ThrowRuntimeException() {
        Long categoriaId = 1L;
        Mockito.when(categoriaJPA.findById(categoriaId)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class,
                ()->service.guardarProducto("Traje Kira","Lorem ipsum",400000,categoriaId,80,"XL","Morioh")
        );
        Mockito.verify(categoriaJPA, Mockito.times(1)).findById(categoriaId);
        Mockito.verify(productoJPA, Mockito.times(0)).save(Mockito.any());
    }

    @Test
    void GivenExisteProducto_When_ConsultarProducto_Then_ReturnLista() {
        ArrayList<ProductoORM> productoSimulado = new ArrayList<>();
        productoSimulado.add(new ProductoORM());
        Mockito.when(productoJPA.findAll()).thenReturn(productoSimulado);

        List<ProductoORM> productosORM = service.consultarProductos();

        Assertions.assertNotNull(productosORM);
        Assertions.assertEquals(productosORM.size(), productoSimulado.size());
        Assertions.assertFalse(productosORM.isEmpty());
        Mockito.verify(productoJPA).findAll();

    }


}