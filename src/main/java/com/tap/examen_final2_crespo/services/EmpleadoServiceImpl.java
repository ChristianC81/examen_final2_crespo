/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.services;


import com.tap.examen_final2_crespo.models.Empleado;
import com.tap.examen_final2_crespo.models.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Long> implements EmpleadoService{

    @Autowired
    EmpleadoRepository empleadoRepository;
    
    @Override
    public CrudRepository<Empleado, Long> getDao() {
        return empleadoRepository;
    }
    
}
