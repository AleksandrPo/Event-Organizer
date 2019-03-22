package com.myfirstapp.eventorganizer.auth.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "user_data")
public class User {
    @Id
    @GeneratedValue
    private Long user_id;

    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private int phone;
    private String user_status;
    private int role_id;

    @Transient
    private String passwordConfirmation;
}
