/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.services;


import com.tap.examen_final2_crespo.models.Maquina;
import com.tap.examen_final2_crespo.models.repositories.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class MaquinaServiceImpl extends GenericServiceImpl<Maquina, Long> implements MaquinaService{

    @Autowired
    MaquinaRepository maquinaRepository;
    
    @Override
    public CrudRepository<Maquina, Long> getDao() {
        return maquinaRepository;
    }
    
}
