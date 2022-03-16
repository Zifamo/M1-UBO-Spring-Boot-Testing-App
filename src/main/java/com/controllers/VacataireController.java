package com.controllers;

import com.dtos.VacataireDto;
import com.services.impl.VacataireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacataire")
public class VacataireController {
    private final VacataireServiceImpl leVacataireService;

    public VacataireController(VacataireServiceImpl vacataireService) {
        this.leVacataireService = vacataireService;
    }

    /**
     * Method to get the vacataire based on the ID
     */
    @GetMapping("/{id}")
    public VacataireDto getVacataire(@PathVariable Long id){
        return leVacataireService.getVacataireById(id);
    }

    /**
     * <p>Get all vacataires in the system</p>
     * @return List<VacataireDto>
     */
    @GetMapping
    public List<VacataireDto> getVacataires() {
        return leVacataireService.getAllVacataires();
    }

    /**
     * Create a new vacataire in the system
     */
    @PostMapping
    public VacataireDto saveVacataire(final @RequestBody VacataireDto vacataireDto){
        return leVacataireService.saveVacataire(vacataireDto);
    }

    /**
     * Delete a vacataire by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteVacataire(@PathVariable Long id){
        return leVacataireService.deleteVacataire(id);
    }
}
