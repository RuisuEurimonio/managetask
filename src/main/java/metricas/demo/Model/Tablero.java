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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Data;
import metricas.demo.Validations.OnCreate;
import metricas.demo.Validations.OnUpdate;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Ruisu's
 */
@Entity
@Table(name = "tablero")
@Data
public class Tablero {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTablero", nullable = false)
    private Integer id;
    
    @Column(name = "nombre", nullable = false)
    @Size(min = 5, max = 45, message = "Ingrese un nombre valido", groups = {OnUpdate.class, OnCreate.class})
    @NotBlank(message = "Ingrese un nombre", groups = OnCreate.class)
    @NotNull(message = "Ingrese un nombre", groups = OnCreate.class)
    private String name;
    
    @Column(name = "descripcion", nullable = false)
    @Size(min = 5, max = 200, message = "Ingrese una descripcion valida", groups = {OnUpdate.class, OnCreate.class})
    @NotBlank(message = "Ingrese una descripcion", groups = OnCreate.class)
    @NotNull(message = "Ingrese una descripcion", groups = OnCreate.class)
    private String description;
    
    @Column(name = "fechaCreacion", nullable = false)
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    
    @ManyToOne()
    @JoinColumn(name = "lista_idLista", nullable = false)
    @JsonIgnoreProperties("tableros")
    private Lista lista;
    
}