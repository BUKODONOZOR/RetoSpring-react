package pe.todotic.tareas.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.todotic.tareas.model.Tarea;
import pe.todotic.tareas.repo.Tarearepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tareas")
public class Tareacontroller {
    
    @Autowired
    private Tarearepository tarearepository;

    @GetMapping("Get")
    List<Tarea> index(){
        return tarearepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Tarea  create(@RequestBody Tarea tarea) {
        return tarearepository.save(tarea);
    }

    @PutMapping("{id}")
    Tarea update(@PathVariable String id,@RequestBody Tarea tarea) {
        Tarea tareaFromDb = tarearepository
        .findById(id)
        .orElseThrow(RuntimeException::new);

        tareaFromDb.setNombre(tarea.getNombre());
        tareaFromDb.setCompletados(tarea.getCompletados());


        return tarearepository.save(tarea);
    
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){

        Tarea tarea = tarearepository
        .findById(id)
        .orElseThrow(RuntimeException::new);


        tarearepository.delete(tarea);
    }

}
