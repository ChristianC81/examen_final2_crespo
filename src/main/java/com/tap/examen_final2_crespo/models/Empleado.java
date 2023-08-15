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
@Document(collection = "Empleado")
public class Empleado {

    @Id
    @NotNull(message = "El ID del empleado no puede ser nulo")
    private Long id_empleado;
    
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    private String nombre;
    
    @NotNull(message = "El apellido no puede ser nulo")
    @Size(min = 1, max = 100, message = "El apellido debe tener entre 1 y 100 caracteres")
    private String apellido;
    
    @NotNull(message = "El número de celular no puede ser nulo")
    @Pattern(regexp = "^[0-9]{7,15}$", message = "El número de celular debe ser un número válido de 7 a 15 dígitos")
    private String celular;
    
    @NotNull(message = "El correo no puede ser nulo")
    @Email(message = "El correo debe ser válido")
    private String correo;
    
    @Size(max = 200, message = "La dirección no debe exceder los 200 caracteres")
    private String direccion;
}
