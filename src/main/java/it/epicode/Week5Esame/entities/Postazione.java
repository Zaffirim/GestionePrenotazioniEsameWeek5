package it.epicode.Week5Esame.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    @Column(name = "numero_massimo_occupanti")
    private int numeroMassimoOccupanti;

    @Enumerated(EnumType.STRING)
    private StatoPostazione stato;

    @ManyToOne
    @JoinColumn(name ="edificio_id")
    private Edificio edificio;


    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    public Postazione() {
        this.stato = StatoPostazione.LIBERA;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", numeroMassimoOccupanti=" + numeroMassimoOccupanti +
                ", stato=" + stato +
                '}';
    }
}
