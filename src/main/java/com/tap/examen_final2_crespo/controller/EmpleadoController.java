/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.controller;


import com.tap.examen_final2_crespo.models.Empleado;
import com.tap.examen_final2_crespo.services.EmpleadoService;
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
@RequestMapping("/api/empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> listarProductos() {
        return new ResponseEntity<>(empleadoService.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Empleado> crearProducto(
            @RequestBody Empleado p) {
        return new ResponseEntity<>(empleadoService.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empleado> actualizarProducto(@PathVariable Long id, @RequestBody Empleado p) {
        Empleado empleado = empleadoService.findById(id);
        if (empleado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                empleado.setNombre(p.getNombre());
                empleado.setApellido(p.getApellido());
                empleado.setCelular(p.getCelular());
                empleado.setCorreo(p.getCorreo());
                empleado.setDireccion(p.getDireccion());
                return new ResponseEntity<>(empleadoService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Empleado> eliminarProducto(@PathVariable Long id) {
        empleadoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}