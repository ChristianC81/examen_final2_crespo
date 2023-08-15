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
@Document(collection = "Parqueadero")
public class Parqueadero {

    @Id
    @NotNull(message = "El ID del parqueadero no puede ser nulo")
    private Long id_parqueadero;
    
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    private String nombre;
    
    @NotNull(message = "El número de plazas no puede ser nulo")
    @Pattern(regexp = "^[0-9]+$", message = "El número de plazas debe ser un número válido")
    private String n_plazas;
    
    @Size(max = 500, message = "La descripción no debe exceder los 500 caracteres")
    private String descripcion;
}
