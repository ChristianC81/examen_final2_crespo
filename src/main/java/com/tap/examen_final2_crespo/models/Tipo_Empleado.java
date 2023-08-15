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
@Document(collection = "Tipo_Empleado")
public class Tipo_Empleado {

    @Id
    @NotNull(message = "El ID del tipo de empleado no puede ser nulo")
    private Long id_tipo_empleado;

    @NotNull(message = "El nombre del puesto no puede ser nulo")
    @Size(min = 1, max = 100, message = "El nombre del puesto debe tener entre 1 y 100 caracteres")
    private String nombre_puesto;

    @Size(max = 500, message = "La descripción no debe exceder los 500 caracteres")
    private String descripcion;
}
