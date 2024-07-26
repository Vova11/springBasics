package com.example.user;

import java.time.LocalDate;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class User {
    private int id;
    @Size(min = 2, message = "Name should have at leat 2 characters")
    @JsonProperty("user_name")
    private String name;
    @Past(message = "Bday should be in the past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
    @JsonIgnore
    private String password;
   
    
    public User(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.password = generateRandomPassword();
    }

    private String generateRandomPassword() {
        Random random = new Random();
        int randomNumber = random.nextInt(22) + 1; // Generates a number between 1 and 22
        return String.valueOf(randomNumber);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", password=" + password + "]";
    }
    public String getPassword() {
        return password;
    }

}
