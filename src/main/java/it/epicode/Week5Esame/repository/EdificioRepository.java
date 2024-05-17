package it.epicode.Week5Esame.repository;

import it.epicode.Week5Esame.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}
