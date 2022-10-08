package com.findyourpet.backend.data;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class PetData {

    private int id;
    private String name;
    private String color;
    private String breed;
    private String size;
    private String gender;
    private int age;
    private String description;
    
    
    
}
