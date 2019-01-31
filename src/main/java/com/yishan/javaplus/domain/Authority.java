package com.yishan.javaplus.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "authorities")
public class Authority implements Serializable, GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "authorities_id_seq")
    @SequenceGenerator(name = "authorities_id_seq", sequenceName = "authorities_id_seq", allocationSize = 1)
    private long id;

    @NonNull
    private String authority;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    public  Authority(){ }

    public Authority(User user, String authority){
        this.user=user;
        this.authority=authority;
    }

    public long getId(){return id;}

    public String getAuthority(){return authority;}

    public void setAuthority(String authority){this.authority = authority;}

    public User getUser(){return user;}

    public void setUser(User user) {
        this.user = user;
    }
}
