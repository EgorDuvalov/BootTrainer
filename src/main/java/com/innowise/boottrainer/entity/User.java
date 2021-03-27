package com.innowise.boottrainer.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String pass;
    private String email;

    public User() {
    }

    public User(String login, String pass, String email) {
        this.login = login;
        this.pass = pass;
        this.email = email;
    }
}
