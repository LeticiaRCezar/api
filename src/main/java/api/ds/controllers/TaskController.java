package api.ds.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; // mapeia requisições do tipo GET
import org.springframework.web.bind.annotation.PathVariable; // mapeia variaveis passadas diretamente via caminho da URL
import org.springframework.web.bind.annotation.PostMapping; // mapeia requisições do tipo POST
import org.springframework.web.bind.annotation.PutMapping; // mapeia requisições do tipo PUT
import org.springframework.web.bind.annotation.RequestBody; // converste objetos JSON em ojetos JAVA
import org.springframework.web.bind.annotation.RequestMapping; // importa anotação para definir o caminho/rota bas do controlador
import org.springframework.web.bind.annotation.RestController; //  importa anotação que define esta classe como um controller REST
import org.springframework.web.servlet.support.ServletUriComponentsBuilder; // Importa utilitario para gerar a URI da requisição atual dinamicamente.

import jakarta.validation.Valid;
import api.ds.models.Task;
import api.ds.services.TaskService;

@RestController 
@RequestMapping ("/task")
@Validated 

public class TaskController {

    @Autowired 
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> findbyId(@PathVariable Long id){
        Task obj = this.taskService.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<Task>> findAllByUserId(@PathVariable Long userId){
        List<Task>obj = this.taskService.findByUserId((userId);
        return ResponseEntity.ok().body(objs);
    }

    @PostMapping  
    public ResponseEntity<Void> create(@valid @RequestBody Task obj){
        this.taskService.create(obj);
        URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(url).build();

    }

    @PostMapping ("/{id}")
    public ResponseEntity<Void> update(@valid @RequestBody Task obj, @PathVariable Long id) {
        obj.setId(id);
        this.taskService.update(obj);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deelete(@PathVariable Long id){
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }  
}

