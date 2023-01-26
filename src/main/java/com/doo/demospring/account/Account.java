package com.doo.demospring.account;

import javax.persistence.*;

@Entity
@EntityListeners({AccountLogger.class})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
