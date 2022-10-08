package com.findyourpet.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.findyourpet.backend.converters.UserConverter;
import com.findyourpet.backend.data.UserData;
import com.findyourpet.backend.entities.User;
import com.findyourpet.backend.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    private UserConverter userConverter = new UserConverter(); 


     //Servicio para registrar en la base de datos (se realiza la conversion de adentro hacia fuera)

     public UserData insert(UserData user){
        if(userRepository.existsById(user.getId()))
        throw new ResponseStatusException(HttpStatus.CONFLICT, "El Usuario no Existe");
        return userConverter.toData(userRepository.save(userConverter.toEntity(user)));
    }

    // servicio para consultar todo en la tabla

    public List<UserData> findAll(){
        return userConverter.toData(userRepository.findAll());
    }

     // consulta en la aplicacion por id

     public UserData findById(int id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Usuario no Existe");
        
        return userConverter.toData(user.get());
    }

    // actualizar una aplicacion

    public UserData update(UserData user){
        if (!userRepository.existsById(user.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Usuario no Existe");
        
        return userConverter.toData(userRepository.save(userConverter.toEntity(user)));
    }

    // eliminar una aplicacion

    public UserData deleteById(int id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Usuario no Existe");
        userRepository.deleteById(id);
        return userConverter.toData(user.get());
    }

}
