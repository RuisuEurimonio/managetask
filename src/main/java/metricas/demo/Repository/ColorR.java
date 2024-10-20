/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Repository;

import java.util.List;
import java.util.Optional;
import metricas.demo.JpaRepository.ColorJR;
import metricas.demo.Model.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruisu's
 */
@Repository
public class ColorR {
    
    @Autowired
    private ColorJR colorJR;
    
    
    public List<Color> getAll(){
        return colorJR.findAll();
    }
    
    public Optional<Color> getById(int id){
        return colorJR.findById(id);
    }
    
    public Color createColor(Color country){
        return colorJR.save(country);
    }
    
    public Color updateColor(Color country){
        return colorJR.save(country);
    }
    
    public void deleteColor(int id){
        colorJR.deleteById(id);
    }
    
}
