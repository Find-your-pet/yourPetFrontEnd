package com.findyourpet.backend.converters;

import com.findyourpet.backend.data.PetData;
import com.findyourpet.backend.entities.Pet;

public class PetConverter extends Converter<Pet, PetData>{
    

    @Override
    public Pet toEntity(PetData object){
        return object == null ? null :Pet.builder()
        .id(object.getId())
        .name(object.getName())
        .color(object.getColor())
        .breed(object.getBreed())
        .size(object.getSize())
        .gender(object.getGender())
        .age(object.getAge())
        .description(object.getDescription())
        

        .build();
    }

    @Override
    public PetData toData(Pet object){
        return object == null ? null :PetData.builder()
        .id(object.getId())
        .name(object.getName())
        .color(object.getColor())
        .breed(object.getBreed())
        .size(object.getSize())
        .gender(object.getGender())
        .age(object.getAge())
        .description(object.getDescription())
        

        .build();
    }
}
