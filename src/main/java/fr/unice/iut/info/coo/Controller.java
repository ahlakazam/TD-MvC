package fr.unice.iut.info.coo;

import java.util.ArrayList;

/**
 * Created by Thomas on 21/10/2016.
 */
public class Controller {

    private BusManager manager = new BusManager();
    private UI affichage = new UI();

    public void start() throws Throwable {

        String commande = new String();
        String choixBus= new String();
        String choixBoite = new String();

        commande = affichage.lireCommande();

        while (commande.charAt(0) != 's')
        {

            switch(commande.charAt(0)) {

                case 'c':
                    choixBus = affichage.getNomDuBus(manager.getAllBusNames());
                    manager.createBus(choixBus);
                    break;

                case 'b':
                    choixBus = affichage.getNomDuBus(manager.getAllBusNames());
                    if(((ArrayList<String>)manager.getAllBusNames()).indexOf(choixBus) == -1) {
                        throw new Throwable("Bus inexistant");
                    }
                    manager.createBox(choixBus, affichage.getNomBoite(manager.getBus(choixBus).getAllBoxNames()));
                    break;

                case 'l':
                    choixBus = affichage.getNomDuBus(manager.getAllBusNames());
                    if(((ArrayList<String>)manager.getAllBusNames()).indexOf(choixBus) == -1) {
                        throw new Throwable("Bus inexistant");
                    }
                    choixBoite = affichage.getNomBoite(manager.getBus(choixBus).getAllBoxNames());
                    if(((ArrayList<String>)manager.getBus(choixBus).getAllBoxNames()).indexOf(choixBoite) == -1) {
                        throw new Throwable("Boite inexistante");
                    }
                    affichage.afficherMessages(((ArrayList<Message>)manager.getAllMessages(choixBus, choixBoite)));
                    break;

                case 'e':
                    choixBus = affichage.getNomDuBus(manager.getAllBusNames());
                    if(((ArrayList<String>)manager.getAllBusNames()).indexOf(choixBus) == -1) {
                        throw new Throwable("Bus inexistant");
                    }
                    choixBoite = affichage.getNomBoite(manager.getBus(choixBus).getAllBoxNames());
                    if(((ArrayList<String>)manager.getBus(choixBus).getAllBoxNames()).indexOf(choixBoite) == -1) {
                        throw new Throwable("Boite inexistante");
                    }
                    String message = affichage.getString("Entrez le texte du message : ");
                    manager.emitIntoBox(choixBus, choixBoite, message);
                    break;

                default:
                    throw new Throwable("Commande inconnue");

            }
            commande = affichage.lireCommande();
        }




    }



}
