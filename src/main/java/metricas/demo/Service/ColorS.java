/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Service;

import java.util.List;
import metricas.demo.CustomExceptions.CustomException;
import metricas.demo.Model.Color;
import metricas.demo.Repository.ColorR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruisu's
 */
@Service
public class ColorS {
    
    @Autowired
    private ColorR colorR;
    
    public List<Color> getAll(){
        return colorR.getAll();
    }
    
    public Color getById(Integer id){
        Color color = colorR.getById(id).orElseThrow(()-> new CustomException("No se encontró el color"));
        return color;
    }
    
    public Color createColor(Color color){
        return colorR.createColor(color);
    }
    
    public Color updateColor(Color category){
        Color colorDB = colorR.getById(category.getId()).orElseThrow(()-> new CustomException("No se encontro el color"));
        if(category.getName() != null) {colorDB.setName(category.getName());}
        if(category.getDescription() != null) {colorDB.setDescription(category.getDescription());}
        return colorR.updateColor(colorDB);
    }
    
    public void deleteColor(Integer id){
        colorR.getById(id).orElseThrow(()-> new CustomException("No se encontro el color"));
        colorR.deleteColor(id);
    }
    
    
}
