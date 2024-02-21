package com.myblog;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class F {
    public static void main(String[] args) {
        F a = new F ();
        String aks = a.bCryptPasswordEncoder().encode("aks");
        System.out.println(aks);
    }
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
