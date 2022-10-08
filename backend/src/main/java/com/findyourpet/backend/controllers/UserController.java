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

import com.findyourpet.backend.data.UserData;
import com.findyourpet.backend.services.UserService;

@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})


public class UserController {
    
    @Autowired 
    private UserService userService;
    
    //metodo registrar

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserData user){
        return new ResponseEntity<>(userService.insert(user), HttpStatus.CREATED);
    }

    // metodo consultar todo

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    // metodo consultar por id
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    // metodo modificar

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserData user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    // metodo Eliminar
     @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.OK);
    }

}
