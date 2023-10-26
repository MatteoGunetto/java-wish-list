package org.lesson.java.gift;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaRegali {

    public static void main(String[] args) {
        ArrayList<Regali> listaRegali = caricaListaRegali();
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

        System.out.println("lista dei regali");
        for (Regali regalo : listaRegali) {
            System.out.println("Destinatario: " + regalo.getDestinatario() + ", Descrizione: " + regalo.getDescrizione());
        }
        scanner.close();

        salvaListaRegali(listaRegali);
    }

    private static void salvaListaRegali(ArrayList<Regali> listaRegali) {
        try (PrintWriter writer = new PrintWriter("lista_regali.txt")) {
            for (Regali regalo : listaRegali) {
                writer.println(regalo.getDestinatario() + " - " + regalo.getDescrizione());
            }
            System.out.println("La lista è stata salvata su un file.");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio della lista su un file.");
        }
    }

    private static ArrayList<Regali> caricaListaRegali() {
        ArrayList<Regali> listaRegali = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("lista_regali.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    String destinatario = parts[0];
                    String descrizione = parts[1];
                    Regali regalo = new Regali(descrizione, destinatario);
                    listaRegali.add(regalo);
                }
            }
        } catch (IOException e) {
            System.out.println("prima lista");
        }
        return listaRegali;
    }
}