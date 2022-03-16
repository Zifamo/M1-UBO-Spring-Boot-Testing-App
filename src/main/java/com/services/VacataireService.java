package com.services;

import com.dtos.VacataireDto;

import java.util.List;

public interface VacataireService {

    /**
     * Ajout d'un vacataire
     */
    VacataireDto saveVacataire(VacataireDto unvacataireDto);

    /**
     * Get vacataire avec id
     */
    VacataireDto getVacataireById(Long vacataireId);

    /**
     * Supprime un vacataire avec son id
     */
    boolean deleteVacataire(Long vacataireId);

    /**
     * Lister tous les vacataires
     */
    List<VacataireDto> getAllVacataires();
}
