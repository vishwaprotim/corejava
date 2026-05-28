package com.protim.corejava.memoryleak;

import java.util.List;
import java.util.ArrayList;

public class MemoryLeak {

    public static List<Double> register =  new ArrayList<>();

    public void populateRegister(){
        for(int i = 0; i < 100_000_000; i++){
            register.add(Math.random());
        }
        System.out.println("[2] End populating register");
    }

    public static void main(String[] args){
        System.out.println("[1] Starting application");
        new MemoryLeak().populateRegister();
        System.out.println("[3] Ending application");
    }
}
