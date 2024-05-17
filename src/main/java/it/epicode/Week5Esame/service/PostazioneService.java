package it.epicode.Week5Esame.service;

import it.epicode.Week5Esame.entities.Postazione;
import it.epicode.Week5Esame.entities.TipoPostazione;
import it.epicode.Week5Esame.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

    public void aggiornaPostazione(Postazione postazione) {
        Postazione p = postazioneRepository.findById(postazione.getId()).get();
        p.setDescrizione(postazione.getDescrizione());
        p.setEdificio(postazione.getEdificio());
        p.setTipo(postazione.getTipo());
        p.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
        postazioneRepository.save(p);
    }

    public Postazione cercaPostazionePerId(int id) {
        return postazioneRepository.findById(id).get();
    }

    public void cancellaPostazione(int id) {
         postazioneRepository.deleteById(id);
    }

    public List<Postazione> ricercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }
}
