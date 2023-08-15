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
@Document(collection = "Fabrica")
public class Fabrica {

    @Id
    @NotNull(message = "El ID de la fábrica no puede ser nulo")
    private Long id_fabrica;
    
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    private String nombre;
    
    @NotNull(message = "El RUC no puede ser nulo")
    private String ruc;
    
    @Size(max = 200, message = "La dirección no debe exceder los 200 caracteres")
    private String direccion;
}
