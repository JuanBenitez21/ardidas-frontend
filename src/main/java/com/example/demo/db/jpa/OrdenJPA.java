package com.example.demo.db.jpa;

import com.example.demo.db.orm.OrdenORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdenJPA extends JpaRepository<OrdenORM,Long> {
    List<OrdenORM> findByFecha(LocalDate fecha);
}
