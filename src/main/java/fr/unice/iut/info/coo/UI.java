package fr.unice.iut.info.coo;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;


public class UI {

    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(input);
    String str = new String();



    public  String lireCommande() {
        System.out.println("------- COMMANDES ----------");
        System.out.println("creer Bus (c)");
        System.out.println("creer Boite (b)");
        System.out.println("lire messages (l)");
        System.out.println("emettre un nouveau message (e)");
        System.out.println("stop (s)");
        System.out.println("Que voulez-vous faire :");
        String str = new String();
        try {
            str = buffer.readLine();
        }catch (Throwable e) {}
        System.out.println("Vous avez saisi : " + str);
        return str;
    }

    public void afficher(String str) {
        System.out.println(str);
    }

    public String getNomDuBus(Set<String> nomsBus) {
       System.out.println("--- Bus disponibles --- ");
       afficheListe(nomsBus);
       System.out.println("==> Nom du bus ?");
       String nomDuBus = new String();
        try {
            nomDuBus = buffer.readLine();
        }catch (Throwable e) {}
        return nomDuBus;
    }

    public void afficheListe(Set<String> noms) {
        for (String nom : noms)
                  System.out.println("\t"+ nom);
    }


    public String getNomBoite(Set<String> nomsBoites) {
        System.out.println("--- Boites disponibles --- ");
        afficheListe(nomsBoites);
        System.out.println("==> Nom de la boite ?");
        String nomBoite = new String();
        try {
            nomBoite = buffer.readLine();
        }catch (Throwable e) {}
         return nomBoite;
    }


    public void afficherMessages(ArrayList<Message> arrayList) {
        int i = 1;
        if (arrayList == null) {
            System.out.println("\t Pas de messages ");
        } else
            for (Message m : arrayList) {
                System.out.println("\t" + i + "-\t" + m);
                i++;
            }
    }




    public String getValeur(String message) {
        System.out.println(message);
        String str = new String();
        try {
            str = buffer.readLine();
        }catch (Throwable e) {}
        return str;
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        String str = new String();
        try {
            str = buffer.readLine();
        }catch (Throwable e) {}
        return str;

    }

}
