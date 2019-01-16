package com.yishan.javaplus.domain;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    private Long id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "zip_code")
    public String zipCode;

    @Column(name = "date_of_birth")
    protected Instant dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    public User(){}

    public Long getId() { return id; }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName  = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public boolean isAccountNonLocked(){
        return true;
    }
    public boolean isAccountNonExpired(){
        return isAccountNonExpired();
    }

    public Collection<? extends GrantedAuthority> getAuthorities(){return null;}

    public boolean isCredentialsNonExpired(){return true;}

    public boolean isEnabled(){return true;}

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){ this.password = password; }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getZipCode(){
        return this.zipCode;
    }
    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }

    public Instant getDateOfBirth(){
        return this.dateOfBirth;
    }
    public void setDateOfBirth(Instant dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
