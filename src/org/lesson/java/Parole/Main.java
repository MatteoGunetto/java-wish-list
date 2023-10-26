package org.lesson.java.Parole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean esci = false;

        while(!esci) {
            Map<Character, Integer> contoCarattere = new HashMap<>();

            System.out.println("Scrivi la parola che vuoi scomporre( !esci per uscire): ");
            String word = input.nextLine();

            if(word.equals("!esci")) {
                esci = true;
                break;
            }

            for(int i=0; i<word.length(); i++) {
                if(contoCarattere.containsKey(word.charAt(i))) {
                    contoCarattere.put((Character)word.charAt(i), contoCarattere.get(word.charAt(i))+(Integer)1);
                }else {
                    contoCarattere.put((Character)word.charAt(i), (Integer)1);
                }
            }

            stampoMap(contoCarattere);
        }
        input.close();

    }
    public static void stampoMap(Map<Character, Integer> map) {
        System.out.println("---------------");
        System.out.println("Result:");
        map.forEach((t, u) -> {
            System.out.println(t + ": " + u);
        });
    }
}