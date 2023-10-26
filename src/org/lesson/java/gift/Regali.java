package org.lesson.java.gift;

public class Regali {
    String descrizione;
    String destinatario;

    public Regali(String descrizione, String destinatario) {
        this.descrizione = descrizione;
        this.destinatario = destinatario;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getDestinatario() {
        return destinatario;
    }
}