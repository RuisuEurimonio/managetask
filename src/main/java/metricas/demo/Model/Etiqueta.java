/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import metricas.demo.Model.Color;
import lombok.Data;
import metricas.demo.Validations.onCreate;
import metricas.demo.Validations.onUpdate;

/**
 *
 * @author Ruisu's
 */
@Entity
@Table(name = "etiqueta")
@Data
public class Etiqueta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtiqueta", nullable = false)
    private Integer id;
    
    
    @Column(name="nombre", nullable = false)
    @Size(min=3,max=30, message="Nombre invalido", groups = {onCreate.class, onUpdate.class})
    @NotNull(message="No se ingreso un nombre", groups = onCreate.class)
    @NotBlank(message="No se ingreso un nombre", groups = onCreate.class)
    private String name;
    
    @ManyToOne()
    @JoinColumn(name = "color_idColor", nullable = false)
    @JsonIgnoreProperties("etiquetas")
    private Color color;
    
    
}
