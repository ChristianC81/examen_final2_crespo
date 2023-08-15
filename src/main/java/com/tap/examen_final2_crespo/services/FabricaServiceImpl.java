/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.services;


import com.tap.examen_final2_crespo.models.Fabrica;
import com.tap.examen_final2_crespo.models.repositories.FabricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class FabricaServiceImpl extends GenericServiceImpl<Fabrica, Long> implements FabricaService{

    @Autowired
    FabricaRepository fabricaRepository;
    
    @Override
    public CrudRepository<Fabrica, Long> getDao() {
        return fabricaRepository;
    }
    
}
