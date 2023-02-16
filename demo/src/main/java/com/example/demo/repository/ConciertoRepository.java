package com.example.demo.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Concierto;

@Repository
public interface ConciertoRepository extends JpaRepository<Concierto, Long>{

    List<Concierto> findByCantante(@Param("cantante") String cantante);

    List<Concierto> findByFecha(@Param("fecha") Date fecha);
}