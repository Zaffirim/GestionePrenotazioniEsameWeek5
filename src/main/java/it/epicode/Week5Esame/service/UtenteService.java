package it.epicode.Week5Esame.service;

import it.epicode.Week5Esame.entities.Utente;
import it.epicode.Week5Esame.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void salvaUtente(Utente utente) {
        utenteRepository.save(utente);
    }

    public void aggiornaUtente(Utente utente){
        Utente i = utenteRepository.findById(utente.getUsername()).get();
        i.setNomeCompleto(utente.getNomeCompleto());
        i.setEmail(utente.getEmail());
        i.setUsername(utente.getUsername());
        utenteRepository.save(i);
    }

    public Utente cercaUtentePerUsername(String username){
        return utenteRepository.findById(username).get();
    }

    public void cancellaUtente(String username){
        utenteRepository.deleteById(username);
    }
}
