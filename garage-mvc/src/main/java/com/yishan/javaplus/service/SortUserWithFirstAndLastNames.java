package com.yishan.javaplus.service;

import com.yishan.javaplus.domain.User;

import java.util.Comparator;

public class SortUserWithFirstAndLastNames implements Comparator<User> {


    @Override
    public int compare(User o1, User o2) {

        if(o1.getFirstName().equals(o2.getFirstName())){

            o1.getLastName().compareTo(o2.getLastName());
        }

        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
