package com.yishan.javaplus.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.lang.Comparable;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails, Comparable<User>{
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="users_id_seq")
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "acc_locker")
    @JsonIgnore
    private boolean accountLocked=Boolean.FALSE;

    @Column(name = "acc_expired")
    @JsonIgnore
    private boolean accountExpired=Boolean.FALSE;

    @Column(name = "cred_expired")
    @JsonIgnore
    private boolean credentialsExpired=Boolean.FALSE;

    @Column(name = "is_enabled")
    @JsonIgnore
    private boolean enabled=Boolean.TRUE;

    @Transient
    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "phone_number", unique = true)
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



    @Override
    @JsonIgnore
    public boolean isAccountNonLocked(){
        return !accountLocked;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired(){
        return !accountExpired;
    }


    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired(){ return !credentialsExpired; }


    @Override
    @JsonIgnore
    public boolean isEnabled(){ return enabled; }

    public void setAccountNonLocked(boolean accountNonLocked) {
        accountNonLocked = accountNonLocked;
    }

    public void setAccountNonExpired(boolean accountExpired) {
        accountExpired = accountExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsExpired) {
        credentialsExpired = credentialsExpired;
    }

    public void setEnabled(boolean enabled) {
        enabled = enabled;
    }


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }


    @JsonIgnore
    public String getPassword(){
        return this.password;
    }

    @JsonProperty
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

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

//    @Override
//    public int compareTo(User o) {
//        return this.getUsername().compareTo(o.getUsername());
//    }

    @Override
    public int compareTo(User o) {
        return this.getUsername().compareTo(o.getUsername());
    }

}
