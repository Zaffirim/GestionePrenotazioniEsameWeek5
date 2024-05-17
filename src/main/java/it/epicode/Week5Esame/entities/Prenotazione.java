package it.epicode.Week5Esame.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;


@Entity
@Data
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "postazione")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente")
    private Utente utente;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    @Column(name = "scadenza_prenotazione")
    private LocalDate scadenzaPrenotazione;



    public Prenotazione(Postazione postazione, Utente utente) {
        if (postazione.getStato().equals(StatoPostazione.LIBERA)) {
            this.postazione = postazione;
            postazione.setStato(StatoPostazione.OCCUPATA);
            this.utente = utente;
            this.dataPrenotazione = LocalDate.now();
            this.scadenzaPrenotazione = dataPrenotazione.plusDays(1);
        }else{
            System.out.println("ciao");
        }
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", dataPrenotazione=" + dataPrenotazione +
                ", scadenzaPrenotazione=" + scadenzaPrenotazione +
                '}';
    }
}
