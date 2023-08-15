/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.controller;


import com.tap.examen_final2_crespo.models.Fabrica;
import com.tap.examen_final2_crespo.services.FabricaService;
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
@RequestMapping("/api/fabrica")
public class FabricaController {

    @Autowired
    FabricaService fabricaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Fabrica>> listarProductos() {
        return new ResponseEntity<>(fabricaService.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Fabrica> crearProducto(
            @RequestBody Fabrica p) {
        return new ResponseEntity<>(fabricaService.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Fabrica> actualizarProducto(@PathVariable Long id, @RequestBody Fabrica p) {
        Fabrica fabrica = fabricaService.findById(id);
        if (fabrica == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fabrica.setNombre(p.getNombre());
                fabrica.setRuc(p.getRuc());
                fabrica.setDireccion(p.getDireccion());
                return new ResponseEntity<>(fabricaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Fabrica> eliminarProducto(@PathVariable Long id) {
        fabricaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}