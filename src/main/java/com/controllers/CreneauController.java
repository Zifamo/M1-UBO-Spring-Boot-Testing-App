package com.controllers;

import com.dtos.CreneauDto;
import com.services.impl.CreneauServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creneau")
public class CreneauController {

    private final CreneauServiceImpl leCreneauService;

    public CreneauController(CreneauServiceImpl leCreneauService) {
        this.leCreneauService = leCreneauService;
    }

    /**
     * Method to get the creneau based on the ID
     */
    @GetMapping("/{id}")
    public CreneauDto getCreneau(@PathVariable Long id){
        return leCreneauService.getCoursById(id);
    }

    /**
     * <p>Get all creneau in the system</p>
     * @return List<CreneauDto>
     */
    @GetMapping
    public List<CreneauDto> getCreneaux() {
        return leCreneauService.getAllCreneaux();
    }

    /**
     * Create a new creneau in the system
     */
    @PostMapping
    public CreneauDto saveCreneau(final @RequestBody CreneauDto creneauDto){
        return leCreneauService.saveCreneau(creneauDto);
    }

    /**
     * Delete a creneau by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCreneau(@PathVariable Long id){
        return leCreneauService.deleteCreneau(id);
    }
}
