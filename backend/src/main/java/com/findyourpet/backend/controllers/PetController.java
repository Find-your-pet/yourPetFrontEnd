package com.findyourpet.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.findyourpet.backend.data.PetData;
import com.findyourpet.backend.services.PetService;

@RestController
@RequestMapping(path = "/api/pet")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class PetController {
    
    @Autowired 
    private PetService petService;
    
    //metodo registrar

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody PetData pet){
        return new ResponseEntity<>(petService.insert(pet), HttpStatus.CREATED);
    }

    // metodo consultar todo

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(petService.findAll(), HttpStatus.OK);
    }

    // metodo consultar por id
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return new ResponseEntity<>(petService.findById(id), HttpStatus.OK);
    }

    // metodo modificar

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PetData pet){
        return new ResponseEntity<>(petService.update(pet), HttpStatus.OK);
    }

    // metodo Eliminar
     @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return new ResponseEntity<>(petService.deleteById(id), HttpStatus.OK);
    }



}
