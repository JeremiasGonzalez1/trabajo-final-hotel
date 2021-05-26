package com.company;
import  Interaction.Client;

public class Main {

    public static void main(String[] args) {
        Client client=new Client();
        client.registration();
        System.out.println(client.toString());
        client.loginAccount();
    }
}
