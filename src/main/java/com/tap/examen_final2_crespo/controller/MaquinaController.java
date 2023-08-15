/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.controller;


import com.tap.examen_final2_crespo.models.Maquina;
import com.tap.examen_final2_crespo.services.MaquinaService;
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
@RequestMapping("/api/maquina")
public class MaquinaController {

    @Autowired
    MaquinaService maquinaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Maquina>> listarProductos() {
        return new ResponseEntity<>(maquinaService.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Maquina> crearProducto(
            @RequestBody Maquina p) {
        return new ResponseEntity<>(maquinaService.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Maquina> actualizarProducto(@PathVariable Long id, @RequestBody Maquina p) {
        Maquina maquina = maquinaService.findById(id);
        if (maquina == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                maquina.setNombre(p.getNombre());
                maquina.setMarca(p.getMarca());
                maquina.setModelo(p.getModelo());
                maquina.setPrecio(p.getPrecio());
                maquina.setDescripcion(p.getDescripcion());
                return new ResponseEntity<>(maquinaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Maquina> eliminarProducto(@PathVariable Long id) {
        maquinaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}