package it.epicode.Week5Esame.service;

import it.epicode.Week5Esame.entities.Edificio;
import it.epicode.Week5Esame.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void salvaEdificio(Edificio edificio) {
        edificioRepository.save(edificio);
    }

    public void aggiornaEdificio(Edificio edificio) {
        Edificio i = edificioRepository.findById(edificio.getId()).get();
        i.setNome(edificio.getNome());
        i.setIndirizzo(edificio.getIndirizzo());
        i.setCitta(edificio.getCitta());
        edificioRepository.save(i);
    }

    public Edificio cercaEdificio(int id) {
        return edificioRepository.findById(id).get();
    }

    public void cancellaEdificio(int id) {
        edificioRepository.deleteById(id);
    }
}
