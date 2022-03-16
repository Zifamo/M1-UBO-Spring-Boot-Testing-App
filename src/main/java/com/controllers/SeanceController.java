package com.controllers;

import com.dtos.SeanceDto;
import com.services.impl.SeanceServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seance")
public class SeanceController {

    private final SeanceServiceImpl laSeanceService;

    public SeanceController(SeanceServiceImpl laSeanceService) {
        this.laSeanceService = laSeanceService;
    }

    /**
     * Method to get the seance based on the ID
     */
    @GetMapping("/{id}")
    public SeanceDto getSeance(@PathVariable Long id){
        return laSeanceService.getSeanceById(id);
    }

    /**
     * <p>Get all seance in the system</p>
     * @return List<SeanceDto>
     */
    @GetMapping
    public List<SeanceDto> getSeances() {
        return laSeanceService.getAllSeances();
    }

    /**
     * Create a new seance in the system
     */
    @PostMapping
    public SeanceDto saveVacataire(final @RequestBody SeanceDto seanceDto){
        return laSeanceService.saveSeance(seanceDto);
    }

    /**
     * Delete a seance by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCours(@PathVariable Long id){
        return laSeanceService.deleteSeance(id);
    }

}
