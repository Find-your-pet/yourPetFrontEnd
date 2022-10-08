package com.findyourpet.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findyourpet.backend.entities.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{
    
}
