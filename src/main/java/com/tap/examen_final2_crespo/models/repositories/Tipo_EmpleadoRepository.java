/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tap.examen_final2_crespo.models.repositories;

import com.tap.examen_final2_crespo.models.Tipo_Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author chris
 */
public interface Tipo_EmpleadoRepository extends MongoRepository<Tipo_Empleado, Long>{
    
}
