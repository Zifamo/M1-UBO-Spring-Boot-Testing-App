package com.services;

import com.dtos.SeanceDto;

import java.util.List;

public interface SeanceService {
    /**
     * Ajout d'une seance
     */
    SeanceDto saveSeance(SeanceDto uneseanceDto);

    /**
     * Get seance avec id
     */
    SeanceDto getSeanceById(Long seanceId);

    /**
     * Supprime une seance avec son id
     */
    boolean deleteSeance(Long seanceId);

    /**
     * Lister toutes les seances
     */
    List<SeanceDto> getAllSeances();
}
