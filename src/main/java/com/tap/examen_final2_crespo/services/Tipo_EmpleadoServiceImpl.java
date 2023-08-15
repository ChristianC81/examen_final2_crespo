/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.services;


import com.tap.examen_final2_crespo.models.Tipo_Empleado;
import com.tap.examen_final2_crespo.models.repositories.Tipo_EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class Tipo_EmpleadoServiceImpl extends GenericServiceImpl<Tipo_Empleado, Long> implements Tipo_EmpleadoService{

    @Autowired
    Tipo_EmpleadoRepository tipo_EmpleadoRepository;
    
    @Override
    public CrudRepository<Tipo_Empleado, Long> getDao() {
        return tipo_EmpleadoRepository;
    }
    
}
