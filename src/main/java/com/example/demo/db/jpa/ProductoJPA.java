package com.example.demo.db.jpa;

import com.example.demo.db.orm.ProductoORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoJPA extends JpaRepository<ProductoORM, Long> {
    List<ProductoORM> findByNombre(String nombre);
}
