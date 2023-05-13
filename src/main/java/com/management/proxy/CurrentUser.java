package com.management.proxy;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@ToString
public class CurrentUser {

    String userId;

    public CurrentUser(){
        System.out.println("currentUSer");
    }
    public CurrentUser(String userId){
        System.out.println("currentUSer");
    }
}
