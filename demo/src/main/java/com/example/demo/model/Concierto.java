package com.example.demo.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "concierto")
@EntityListeners(AuditingEntityListener.class)
public class Concierto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Cantante")
    private String cantante;

    @Column(name = "Fecha")
    @CreatedDate
    private Date fecha;


    @Column(name = "Entradas_Disponibles")
    private int entradasDisponibles;

    public Concierto() {

    }

    public Concierto(Long id, String cantante,Date fecha,int entradasDisponibles) {
        this.id = id;
        this.cantante = cantante;
        this.fecha = fecha;
        this.entradasDisponibles = entradasDisponibles;
    }

    public Long getId() {
        return id;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public int getEntradasDisponibles() {
        return entradasDisponibles;
    }

    public void setEntradasDisponibles(int entradasDisponibles) {
        this.entradasDisponibles = entradasDisponibles;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Concierto{" +
                "id=" + id +
                ", cantante='" + cantante +
                ", fecha=" + fecha +
                ", entradasDisponibles=" + entradasDisponibles +
                '}';
    }
}