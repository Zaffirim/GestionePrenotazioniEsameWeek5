package it.epicode.Week5Esame.repository;

import it.epicode.Week5Esame.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {
}
