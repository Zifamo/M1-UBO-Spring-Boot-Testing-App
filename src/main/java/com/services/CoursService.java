package com.services;

import com.dtos.CoursDto;


import java.util.List;

public interface CoursService {

    /**
     * Ajout d'un cours
     */
    CoursDto saveCours(CoursDto uncoursDto);

    /**
     * Get cours avec id
     */
    CoursDto getCoursById(Long coursId);

    /**
     * Supprime un cours avec son id
     */
    boolean deleteCours(Long coursId);

    /**
     * Lister tous les cours
     */
    List<CoursDto> getAllCours();
}
