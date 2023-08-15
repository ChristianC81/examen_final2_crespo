/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.services;


import com.tap.examen_final2_crespo.models.Parqueadero;
import com.tap.examen_final2_crespo.models.repositories.ParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class ParqueaderoServiceImpl extends GenericServiceImpl<Parqueadero, Long> implements ParqueaderoService{

    @Autowired
    ParqueaderoRepository personaRepository;
    
    @Override
    public CrudRepository<Parqueadero, Long> getDao() {
        return personaRepository;
    }
    
}
