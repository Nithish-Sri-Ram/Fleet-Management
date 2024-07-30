package com.example.fleetmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Getter
@Setter

public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(strategy = "native",name = "native")
    private int id;


    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 letters long")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    private String cargoService;

    @NotBlank(message = "Subject must not be blank")
    @Size(min = 5,message = "Message must at least be 5 letters long")
    private String subject;

    @NotBlank(message = "Message must not be blank")
    @Size(min = 10,message = "Message must be at least 10 letters long")
    private String message;

    // Getters and Setters
}

//Sign Up to Drive