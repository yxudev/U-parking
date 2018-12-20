//package com.yishan.javaplus.domain;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.security.PublicKey;
//import java.time.Instant;
//
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    private Long id;
//
//    @Column(name = "first_name")
//    public String firstName;
//
//    @Column(name = "last_name")
//    public String lastName;
//
//    @Column(name = "email", unique = true)
//    private String email;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "username", unique = true)
//    private String username;
//
//    @Column(name = "zipcode")
//    public int zipcode;
//
//    @Column(name = "date_of_birth")
//    protected Instant dateOfBirth;
//
//    @Column(name = "your_phone_number")
//    private String phoneNumber;
//
//    public User(){
//
//    }
//    public String getEmail(){
//        return this.email;
//    }
//    public void setEmail(String email){
//        this.email = email;
//    }
//
//    public String getFirstName(){
//        return this.firstName;
//    }
//    public void setFirstName(String firstName){
//        this.firstName  = firstName;
//    }
//
//    public String getLastName(){
//        return this.lastName;
//    }
//    public void setLastName(String lastName){
//        this.lastName = lastName;
//    }
//
//    public String getPassword(){
//        return this.password;
//    }
//    public void setPassword(String password){
//        this.password = password;
//    }
//
//    public String getUsername(){
//        return this.username;
//    }
//    public void setUsername(String username){
//        this.username = username;
//    }
//
//    public Integer getZipcode(){
//        return this.zipcode;
//    }
//    public void setZipcode(Integer zipcode){
//        this.zipcode = zipcode;
//    }
//
//    public Instant getDateOfBirth(){
//        return this.dateOfBirth;
//    }
//    public void setDateOfBirth(Instant dateOfBirth){
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getPhoneNumber(){
//        return this.phoneNumber;
//    }
//    public void setPhoneNumber(String phoneNumber){
//        this.phoneNumber = phoneNumber;
//    }
//}