package com.services.impl;

import com.dtos.VacataireDto;
import com.entities.Vacataire;
import com.repositories.VacataireRepository;
import com.services.VacataireService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("vacataireService")
public class VacataireServiceImpl implements VacataireService {
    private final VacataireRepository leVacataireRepository;

    public VacataireServiceImpl(VacataireRepository vacataireRepository) {
        this.leVacataireRepository = vacataireRepository;
    }

    @Override
    public VacataireDto saveVacataire(VacataireDto unvacataireDto) {
        Vacataire vacataire = vacataireDtoToEntity(unvacataireDto);
        vacataire = leVacataireRepository.save(vacataire);
        return vacataireEntityToDto(vacataire);
    }

    @Override
    public VacataireDto getVacataireById(Long vacataireId) {
        Vacataire leVacataire = leVacataireRepository.findById(vacataireId).orElseThrow(
                () -> new EntityNotFoundException("Vacataire pas trouvé"));
        return vacataireEntityToDto(leVacataire);
    }

    @Override
    public boolean deleteVacataire(Long vacataireId) {
        leVacataireRepository.deleteById(vacataireId);
        return true;
    }

    @Override
    public List<VacataireDto> getAllVacataires() {
        List<VacataireDto> vacataireDtos = new ArrayList<>();
        List<Vacataire> vacataires = leVacataireRepository.findAll();
        vacataires.forEach(vacataire -> {
            vacataireDtos.add(vacataireEntityToDto(vacataire));
        });
        return vacataireDtos;
    }

    /**
     * Map vacataire entité à vacataire dto
     */
    private VacataireDto vacataireEntityToDto(Vacataire unVacataire) {
        VacataireDto vacataireDto = new VacataireDto();
        vacataireDto.setId(unVacataire.getId());
        vacataireDto.setLogin(unVacataire.getLogin());
        vacataireDto.setMotDePasse(unVacataire.getMotDePasse());
        vacataireDto.setNomUsuel(unVacataire.getNomUsuel());
        vacataireDto.setPrenom(unVacataire.getPrenom());
        vacataireDto.setMail(unVacataire.getMail());
        vacataireDto.setLeCours(unVacataire.getLeCours());
        vacataireDto.setLesSeances(unVacataire.getLesSeances());
        return vacataireDto;
    }

    /**
     * Map vacataire dto  à vacataire entité
     */
    private Vacataire vacataireDtoToEntity(VacataireDto unVacataireDto){
        Vacataire unVacataire = new Vacataire();
        unVacataire.setId(unVacataireDto.getId());
        unVacataire.setLogin(unVacataireDto.getLogin());
        unVacataire.setMotDePasse(unVacataireDto.getMotDePasse());
        unVacataire.setNomUsuel(unVacataireDto.getNomUsuel());
        unVacataire.setPrenom(unVacataireDto.getPrenom());
        unVacataire.setMail(unVacataireDto.getMail());
        unVacataire.setLeCours(unVacataireDto.getLeCours());
        unVacataire.setLesSeances(unVacataireDto.getLesSeances());
        return unVacataire;
    }
}
