package it.epicode.Week5Esame.repository;

import it.epicode.Week5Esame.entities.Prenotazione;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

}
