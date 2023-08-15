/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.examen_final2_crespo.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;
/**
 *
 * @author chris
 */
@Data
@AllArgsConstructor
@Document(collection = "Maquina")
public class Maquina {

    @Id
    @NotNull(message = "El ID de la máquina no puede ser nulo")
    private Long id_maquina;
    
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    private String nombre;
    
    @NotNull(message = "La marca no puede ser nula")
    @Size(min = 1, max = 50, message = "La marca debe tener entre 1 y 50 caracteres")
    private String marca;
    
    @NotNull(message = "El modelo no puede ser nulo")
    @Size(min = 1, max = 50, message = "El modelo debe tener entre 1 y 50 caracteres")
    private String modelo;
    
    @Min(value = 0, message = "El precio no puede ser negativo")
    private double precio;
    
    @Size(max = 500, message = "La descripción no debe exceder los 500 caracteres")
    private String descripcion;
}