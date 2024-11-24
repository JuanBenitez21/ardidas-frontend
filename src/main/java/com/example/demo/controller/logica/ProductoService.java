package com.example.demo.controller.logica;


import com.example.demo.db.jpa.CategoriaJPA;
import com.example.demo.db.jpa.ProductoJPA;
import com.example.demo.db.orm.CategoriaORM;
import com.example.demo.db.orm.ProductoORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService {

 private final ProductoJPA productoJPA;
 private final CategoriaJPA categoriaJPA;

 public ProductoORM guardarProducto(String nombre, String descripcion, double precio,Long categoria,int stock,String talla, String marca) {
  CategoriaORM categoriaORM= categoriaJPA.findById(categoria).orElseThrow(() -> new RuntimeException("No existe la categoria"));
  ProductoORM nuevoProducto = new ProductoORM();
  nuevoProducto.setNombre(nombre);
  nuevoProducto.setDescripcion(descripcion);
  nuevoProducto.setPrecio(precio);
  nuevoProducto.setCategoria(categoriaORM);
  nuevoProducto.setStock(stock);
  nuevoProducto.setTalla(talla);
  nuevoProducto.setMarca(marca);
  return productoJPA.save(nuevoProducto);
 }

 public List<ProductoORM> consultarProductos() {
  return productoJPA.findAll();
 }


}
