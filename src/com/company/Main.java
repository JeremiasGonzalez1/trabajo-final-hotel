package com.company;
import Empleados.Employee;
import  Interaction.Client;
import Sign.Sign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Client client=new Client();
//        client.registration();
//        System.out.println(client.toString());
//        client.loginAccount();
        Employee empleado = new Employee("maxi", "1234", "Tarde", 45000);

//        empleado.signIn();
//
//        empleado.signOut();

        Employee empleado2 = new Employee("pedro ", "1234", "Tarde", 45000);

//        empleado2.signIn();
//
//        empleado2.signOut();

        List<Sign> signs = new ArrayList<>();

        signs = empleado2.seeSigns();

        for(Sign aux : signs)
        {
            if(empleado.getUsername().equals(aux.getUsername())){
                System.out.println(aux.toString());
            }
        }


    }
}
