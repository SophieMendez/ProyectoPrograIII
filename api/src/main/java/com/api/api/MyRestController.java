package com.api.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping ("/api")

public class MyRestController {

     @Autowired
    DatabaseService databaseService;

    @GetMapping
    public String api() {
        return "Api en Proceso";
    }
    
    @GetMapping("all")
    public List <Notas> all(){
        return databaseService.getAllNotes();  
    }

    @GetMapping("/byid")
    public Notas all(int id){
        return databaseService.getNotas(id);    
    }

    @PutMapping("/byid")
    public void update(String nombre, String descripcion, int id) {
 
        Notas notas = new Notas(id, nombre, nombre, descripcion);
        databaseService.updateNotas(notas) ;
    }
    
    @PostMapping()
    public void insert(String nombre, String descripcion) {
 
        Notas notas = new Notas(0, nombre, nombre, descripcion);
        databaseService.insertNotas(notas) ;
    }

    @DeleteMapping("/byid")
    public void delete(int id) {
 
        databaseService.deleteNotas(id) ;
    }
}
