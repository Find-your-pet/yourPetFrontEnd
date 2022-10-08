package com.findyourpet.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.findyourpet.backend.converters.PetConverter;
import com.findyourpet.backend.data.PetData;
import com.findyourpet.backend.entities.Pet;
import com.findyourpet.backend.repositories.PetRepository;

@Service
public class PetService {
    
    @Autowired
    private PetRepository petRepository;

    private PetConverter petConverter = new PetConverter(); 


     //Servicio para registrar en la base de datos (se realiza la conversion de adentro hacia fuera)

     public PetData insert(PetData pet){
        if(petRepository.existsById(pet.getId()))
        throw new ResponseStatusException(HttpStatus.CONFLICT, "La Mascota no Existe");
        return petConverter.toData(petRepository.save(petConverter.toEntity(pet)));
    }

    // servicio para consultar todo en la tabla

    public List<PetData> findAll(){
        return petConverter.toData(petRepository.findAll());
    }

     // consulta en la aplicacion por id

     public PetData findById(int id){
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La Mascota no Existe");
        
        return petConverter.toData(pet.get());
    }

    // actualizar una aplicacion

    public PetData update(PetData pet){
        if (!petRepository.existsById(pet.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La Mascota no Existe");
        
        return petConverter.toData(petRepository.save(petConverter.toEntity(pet)));
    }

    // eliminar una aplicacion

    public PetData deleteById(int id){
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La Mascota no Existe");
        petRepository.deleteById(id);
        return petConverter.toData(pet.get());
    }

}
