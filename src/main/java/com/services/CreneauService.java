package com.services;

import com.dtos.CreneauDto;

import java.util.List;

public interface CreneauService {
    /**
     * Ajout d'un creneau
     */
    CreneauDto saveCreneau(CreneauDto uncreneauDto);

    /**
     * Get creneau avec id
     */
    CreneauDto getCoursById(Long creneauId);

    /**
     * Supprime un creneau avec son id
     */
    boolean deleteCreneau(Long creneauId);

    /**
     * Lister tous les creneaux
     */
    List<CreneauDto> getAllCreneaux();
}
