package it.epicode.Week5Esame.repository;

import it.epicode.Week5Esame.entities.Postazione;
import it.epicode.Week5Esame.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}
