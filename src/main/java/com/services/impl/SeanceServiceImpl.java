package com.services.impl;

import com.dtos.SeanceDto;
import com.entities.Seance;
import com.repositories.SeanceRepository;
import com.services.SeanceService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("seanceService")
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository laSeanceRepository;

    public SeanceServiceImpl(SeanceRepository laSeanceRepository) {
        this.laSeanceRepository = laSeanceRepository;
    }

    @Override
    public SeanceDto saveSeance(SeanceDto uneseanceDto) {
        Seance laSeance = seanceDtoToEntity(uneseanceDto);
        laSeance = laSeanceRepository.save(laSeance);
        return seanceEntityToDto(laSeance);
    }

    @Override
    public SeanceDto getSeanceById(Long seanceId) {
        Seance laSeance = laSeanceRepository.findById(seanceId).orElseThrow(
                () -> new EntityNotFoundException("Seance pas trouvé"));
        return seanceEntityToDto(laSeance);
    }

    @Override
    public boolean deleteSeance(Long seanceId) {
        laSeanceRepository.deleteById(seanceId);
        return true;
    }

    @Override
    public List<SeanceDto> getAllSeances() {
        List<SeanceDto> lesSeancesDto = new ArrayList<>();
        List<Seance> lesSeances = laSeanceRepository.findAll();
        lesSeances.forEach(uneSeance -> {
            lesSeancesDto.add(seanceEntityToDto(uneSeance));
        });
        return lesSeancesDto;
    }

    /**
     * Map seance entité à vacataire dto
     */
    private SeanceDto seanceEntityToDto(Seance uneSeance) {
        SeanceDto seanceDto = new SeanceDto();
        seanceDto.setId(uneSeance.getId());
        seanceDto.setCreneauSeance(uneSeance.getCreneauSeance());
        seanceDto.setCommentaire(uneSeance.getCommentaire());
        seanceDto.setDureeEffective(uneSeance.getDureeEffective());
        seanceDto.setValide(uneSeance.isValide());
        seanceDto.setEstEffectue(uneSeance.isEstEffectue());
        return seanceDto;
    }

    /**
     * Map seance entité à vacataire dto
     */
    private Seance seanceDtoToEntity(SeanceDto uneSeanceDto) {
        Seance laSeance = new Seance();
        laSeance.setId(uneSeanceDto.getId());
        laSeance.setCreneauSeance(uneSeanceDto.getCreneauSeance());
        laSeance.setCommentaire(uneSeanceDto.getCommentaire());
        laSeance.setDureeEffective(uneSeanceDto.getDureeEffective());
        laSeance.setValide(uneSeanceDto.isValide());
        laSeance.setEstEffectue(uneSeanceDto.isEstEffectue());
        return laSeance;
    }
}
