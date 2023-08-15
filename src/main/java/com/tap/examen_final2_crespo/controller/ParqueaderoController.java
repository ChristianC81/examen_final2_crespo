/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.controller;


import com.tap.examen_final2_crespo.models.Parqueadero;
import com.tap.examen_final2_crespo.services.ParqueaderoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chris
 */
@RestController
    @RequestMapping("/api/parqueadero")
public class ParqueaderoController {

    @Autowired
    ParqueaderoService parqueaderoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Parqueadero>> listarProductos() {
        return new ResponseEntity<>(parqueaderoService.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Parqueadero> crearProducto(
            @RequestBody Parqueadero p) {
        return new ResponseEntity<>(parqueaderoService.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Parqueadero> actualizarProducto(@PathVariable Long id, @RequestBody Parqueadero p) {
        Parqueadero parqueadero = parqueaderoService.findById(id);
        if (parqueadero == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                parqueadero.setNombre(p.getNombre());
                parqueadero.setN_plazas(p.getN_plazas());
                parqueadero.setDescripcion(p.getDescripcion());
                return new ResponseEntity<>(parqueaderoService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Parqueadero> eliminarProducto(@PathVariable Long id) {
        parqueaderoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}