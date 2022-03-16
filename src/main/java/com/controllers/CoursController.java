package com.controllers;

import com.dtos.CoursDto;
import com.services.impl.CoursServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    private final CoursServiceImpl leCoursService;

    public CoursController(CoursServiceImpl unCoursService) {
        this.leCoursService = unCoursService;
    }


    /**
     * Method to get the cours based on the ID
     */
    @GetMapping("/{id}")
    public CoursDto getCours(@PathVariable Long id){
        return leCoursService.getCoursById(id);
    }

    /**
     * <p>Get all cours in the system</p>
     * @return List<CoursDto>
     */
    @GetMapping
    public List<CoursDto> getCours() {
        return leCoursService.getAllCours();
    }

    /**
     * Create a new cours in the system
     */
    @PostMapping
    public CoursDto saveVacataire(final @RequestBody CoursDto coursDto){
        return leCoursService.saveCours(coursDto);
    }

    /**
     * Delete a cours by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCours(@PathVariable Long id){
        return leCoursService.deleteCours(id);
    }

}
