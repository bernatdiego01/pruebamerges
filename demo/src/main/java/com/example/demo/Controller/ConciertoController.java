package com.example.demo.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Concierto;
import com.example.demo.repository.ConciertoRepository;

@RestController
@RequestMapping("/api")
public class ConciertoController {

    @Autowired
    private ConciertoRepository repository;


    @GetMapping(value = "/conciertos_json", produces={"application/json"})

    public List<Concierto> allConciertosJSON(){
        return repository.findAll();
    }
    @GetMapping(value = "/conciertos_xml", produces={"application/xml"})

    public List<Concierto> allConciertosXML(){
        return repository.findAll();
    }

    @GetMapping(value="/concierto_json/{cantante}", produces={"application/json"})
    public List<Concierto> findByCantanteJSON(@PathVariable("cantante") String cantante) {
        return repository.findByCantante(cantante);
    }
    @GetMapping(value="/concierto_xml/{cantante}", produces={"application/xml"})
    public List<Concierto> findByCantanteXML(@PathVariable("cantante") String cantante) {
        return repository.findByCantante(cantante);
    }

    @GetMapping(value="/concierto_json/{fecha}", produces={"application/json"})
    public List<Concierto> findByFechaJSON(@PathVariable("fecha") Date fecha) {
        return repository.findByFecha(fecha);
    }
    @GetMapping(value="/concierto_xml/{fecha}", produces={"application/xml"})
    public List<Concierto> findByFechaXML(@PathVariable("fecha") Date fecha) {
        return repository.findByFecha(fecha);
    }

    @PostMapping("/concierto")
    public Concierto createConcierto(@RequestBody Concierto concierto) {
        return repository.save(concierto);
    }

    @PutMapping("/concierto/{id}")
    public Concierto updateConcierto(@PathVariable Long id ,@RequestBody Concierto concierto) {
        return repository.save(concierto);
    }

    @DeleteMapping("/concierto/{id}")
    public void deleteConcierto(@PathVariable("id") Long id) {repository.deleteById(id);
    }
    @DeleteMapping("/conciertos")
    public void deleteAllConciertos(){
        repository.deleteAll();
    }

    @GetMapping("/total_conciertos")
    public Long countConciertos(){
       return repository.count();
    }


}
