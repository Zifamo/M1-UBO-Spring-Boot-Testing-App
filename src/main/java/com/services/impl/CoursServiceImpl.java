package com.services.impl;

import com.dtos.CoursDto;
import com.entities.Cours;
import com.repositories.CoursRepository;
import com.services.CoursService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("coursService")
public class CoursServiceImpl implements CoursService {

    private final CoursRepository leCoursRepository;

    public CoursServiceImpl(CoursRepository leCoursRepository) {
        this.leCoursRepository = leCoursRepository;
    }

    @Override
    public CoursDto saveCours(CoursDto uncoursDto) {
        Cours cours = coursDtoToEntity(uncoursDto);
        cours = leCoursRepository.save(cours);
        return coursEntityToDto(cours);
    }

    @Override
    public CoursDto getCoursById(Long coursId) {
        Cours leCours = leCoursRepository.findById(coursId).orElseThrow(
                () -> new EntityNotFoundException("Cours pas trouvé"));
        return coursEntityToDto(leCours);
    }

    @Override
    public boolean deleteCours(Long coursId) {
        leCoursRepository.deleteById(coursId);
        return true;
    }

    @Override
    public List<CoursDto> getAllCours() {
        List<CoursDto> lesCoursDto = new ArrayList<>();
        List<Cours> lesCours = leCoursRepository.findAll();
        lesCours.forEach(unCours -> {
            lesCoursDto.add(coursEntityToDto(unCours));
        });
        return lesCoursDto;
    }

    /**
     * Map cours entité à vacataire dto
     */
    private CoursDto coursEntityToDto(Cours unCours) {
        CoursDto coursDto = new CoursDto();
        coursDto.setId(unCours.getId());
        coursDto.setIntitule(unCours.getIntitule());
        coursDto.setLesCreneaux(unCours.getLesCreneaux());
        coursDto.setLesFilieres(unCours.getLesFilieres());
        coursDto.setLesVacataires(unCours.getLesVacataires());
        return coursDto;
    }

    /**
     * Map cours entité à vacataire dto
     */
    private Cours coursDtoToEntity(CoursDto uncoursDto) {
        Cours leCours = new Cours();
        leCours.setId(uncoursDto.getId());
        leCours.setIntitule(uncoursDto.getIntitule());
        leCours.setLesCreneaux(uncoursDto.getLesCreneaux());
        leCours.setLesVacataires(uncoursDto.getLesVacataires());
        leCours.setLesFilieres(uncoursDto.getLesFilieres());
        return leCours;
    }
}
