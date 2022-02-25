package pe.todotic.tareas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value ="tarea")
@Data 

public class Tarea {
    @Id
    private String id;
    private String nombre;
    private boolean completados;
    
    public String getNombre() {
        return nombre;
    }
    public Object setNombre(Object nombre) {
        return nombre;
    }
    public boolean getCompletados() {
        return completados;
    }
    public boolean setCompletados(Object completado) {
        return completados;
    }

    
   
}
