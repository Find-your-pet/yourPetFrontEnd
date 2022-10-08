package com.findyourpet.backend.converters;

import com.findyourpet.backend.data.UserData;
import com.findyourpet.backend.entities.User;

public class UserConverter extends Converter<User, UserData>{
    

    @Override
    public User toEntity(UserData object){
        return object == null ? null :User.builder()
        .id(object.getId())
        .name(object.getName())
        .lastname(object.getLastname())
        .email(object.getEmail())
        .password(object.getPassword())
        .phone(object.getPhone())
        .build();
    }

    @Override
    public UserData toData(User object){
        return object == null ? null :UserData.builder()
        .id(object.getId())
        .name(object.getName())
        .lastname(object.getLastname())
        .email(object.getEmail())
        //.password(object.getPassword())
        .phone(object.getPhone())
        .build();

        
    }
}
