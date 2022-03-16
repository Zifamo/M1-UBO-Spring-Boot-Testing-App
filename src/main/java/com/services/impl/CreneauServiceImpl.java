package com.services.impl;

import com.dtos.CreneauDto;
import com.entities.Creneau;
import com.repositories.CreneauRepository;
import com.services.CreneauService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("creneauService")
public class CreneauServiceImpl implements CreneauService {
    private final CreneauRepository leCreneauRepository;

    public CreneauServiceImpl(CreneauRepository leCreneauRepository) {
        this.leCreneauRepository = leCreneauRepository;
    }

    @Override
    public CreneauDto saveCreneau(CreneauDto uncreneauDto) {
        Creneau leCreneau = creneauDtoToEntity(uncreneauDto);
        leCreneau = leCreneauRepository.save(leCreneau);
        return creneauEntityToDto(leCreneau);
    }

    @Override
    public CreneauDto getCoursById(Long creneauId) {
        Creneau leCreneau = leCreneauRepository.findById(creneauId).orElseThrow(
                () -> new EntityNotFoundException("Creneau pas trouvé"));
        return creneauEntityToDto(leCreneau);
    }

    @Override
    public boolean deleteCreneau(Long creneauId) {
        leCreneauRepository.deleteById(creneauId);
        return true;
    }

    @Override
    public List<CreneauDto> getAllCreneaux() {
        List<CreneauDto> lesCreneauxDto = new ArrayList<>();
        List<Creneau> lesCreneaux = leCreneauRepository.findAll();
        lesCreneaux.forEach(unCreneau -> {
            lesCreneauxDto.add(creneauEntityToDto(unCreneau));
        });
        return lesCreneauxDto;
    }

    /**
     * Map creneau entité à vacataire dto
     */
    private CreneauDto creneauEntityToDto(Creneau unCreneau) {
        CreneauDto creneauDto = new CreneauDto();
        creneauDto.setTypeCreneau(unCreneau.getTypeCreneau());
        creneauDto.setId(unCreneau.getId());
        creneauDto.setDuree(unCreneau.getDuree());
        creneauDto.setLecours(unCreneau.getLecours());
        creneauDto.setLesSeances(unCreneau.getLesSeances());
        return creneauDto;
    }

    /**
     * Map seance entité à vacataire dto
     */
    private Creneau creneauDtoToEntity(CreneauDto unCreneauDto) {
        Creneau leCreneau = new Creneau();
        leCreneau.setTypeCreneau(unCreneauDto.getTypeCreneau());
        leCreneau.setId(unCreneauDto.getId());
        leCreneau.setDuree(unCreneauDto.getDuree());
        leCreneau.setLecours(unCreneauDto.getLecours());
        leCreneau.setLesSeances(unCreneauDto.getLesSeances());
        return leCreneau;
    }
}
