/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.controller;


import com.tap.examen_final2_crespo.models.Tipo_Empleado;
import com.tap.examen_final2_crespo.services.Tipo_EmpleadoService;
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
@RequestMapping("/api/tipo_Empleado")
public class Tipo_EmpleadoController {

    @Autowired
    Tipo_EmpleadoService tipo_EmpleadoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Tipo_Empleado>> listarProductos() {
        return new ResponseEntity<>(tipo_EmpleadoService.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Tipo_Empleado> crearProducto(
            @RequestBody Tipo_Empleado p) {
        return new ResponseEntity<>(tipo_EmpleadoService.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Tipo_Empleado> actualizarProducto(@PathVariable Long id, @RequestBody Tipo_Empleado p) {
        Tipo_Empleado tipo_Empleado = tipo_EmpleadoService.findById(id);
        if (tipo_Empleado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                tipo_Empleado.setNombre_puesto(p.getNombre_puesto());
                tipo_Empleado.setDescripcion(p.getDescripcion());
                return new ResponseEntity<>(tipo_EmpleadoService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Tipo_Empleado> eliminarProducto(@PathVariable Long id) {
        tipo_EmpleadoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}