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


public class UserData {
    
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private int phone;
  
}
