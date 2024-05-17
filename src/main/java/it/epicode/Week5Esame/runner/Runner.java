package it.epicode.Week5Esame.runner;

import it.epicode.Week5Esame.entities.*;
import it.epicode.Week5Esame.service.EdificioService;
import it.epicode.Week5Esame.service.PostazioneService;
import it.epicode.Week5Esame.service.PrenotazioneService;
import it.epicode.Week5Esame.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;



    @Override
    public void run(String... args) throws Exception {

        Edificio edificio1 = new Edificio();
        edificio1.setNome("Isola 5");
        edificio1.setCitta("Pescara");
        edificio1.setIndirizzo("Via Piave");


        System.out.println(edificio1.toString());
        edificioService.salvaEdificio(edificio1);


        Utente utente1 = new Utente();
        utente1.setNomeCompleto("Milo Zaffiri");
        utente1.setEmail("zaffirim@gmail.z");


        System.out.println(utente1.toString());
        utenteService.salvaUtente(utente1);


        Postazione postazione1 = new Postazione();
        postazione1.setTipo(TipoPostazione.OPENSPACE);
        postazione1.setDescrizione("Vista Mare");
        postazione1.setNumeroMassimoOccupanti(10);
        postazione1.setEdificio(edificio1);

        Prenotazione prenotazione1 = new Prenotazione(postazione1, utente1);


        System.out.println(prenotazione1.toString());
        postazioneService.salvaPostazione(postazione1);
        prenotazioneService.salvaPrenotazione(prenotazione1);


        List<Postazione> postazioni = postazioneService.ricercaPostazioni(TipoPostazione.OPENSPACE,"Pescara");

        postazioni.stream().forEach(System.out::println);


    }

}
