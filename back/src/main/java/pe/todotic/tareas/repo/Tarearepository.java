package pe.todotic.tareas.repo;
import org.springframework.data.mongodb.repository.MongoRepository;

import pe.todotic.tareas.model.Tarea;

public interface Tarearepository  extends MongoRepository<Tarea, String> {
    
}
