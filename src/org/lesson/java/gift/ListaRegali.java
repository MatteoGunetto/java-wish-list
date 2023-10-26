package org.lesson.java.gift;


import java.util.ArrayList;
import java.util.Scanner;

public class ListaRegali {
    public static void main(String[] args) {
        ArrayList<Regali> listaRegali = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lista così quest'anno non dimentichi i regali");

        boolean continua = true;
        while (continua) {
            System.out.print("Cosa vuoi regalare? ");
            String descrizione = scanner.nextLine();
            System.out.print("per chi è il regalo? ");
            String destinatario = scanner.nextLine();

            Regali regalo = new Regali(descrizione, destinatario);
            listaRegali.add(regalo);

            System.out.println("Regalo aggiunto alla lista.");
            System.out.println("Regali in lista: " + listaRegali.size());

            System.out.print("Vuoi aggiungere un altro regalo? (s/n): ");
            String risposta = scanner.nextLine().toLowerCase();
            continua = risposta.equals("s");
        }

        // Stampare la lista
        System.out.println("lista dei regali");
        for (Regali regalo : listaRegali) {
            System.out.println("Destinatario: " + regalo.getDestinatario() + ", Descrizione: " + regalo.getDescrizione());
        }
        scanner.close();
    }
}