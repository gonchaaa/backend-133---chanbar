package com.chanbar.backend133_chanbar.controllers;

import com.chanbar.backend133_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend133_chanbar.services.IVacancyService;
import com.chanbar.backend133_chanbar.services.Impls.VacancyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vacancies")
public class VacancyController {

    private final IVacancyService vacancyService;

    @PostMapping
    VacancyDTO createVacancy(@RequestBody VacancyDTO vacancyDTO){
        return vacancyService.createVacancy(vacancyDTO);
    }
    @GetMapping
    List<VacancyDTO> getAllVacancies(){
        return vacancyService.getAllVacancies();
    }
    @GetMapping("/{id}")
    VacancyDTO getVacancyById(@PathVariable(name = "id") Long id){
        return vacancyService.getVacancyById(id);
    }
    @PutMapping("/{id}")
    VacancyDTO updateVacancy(@PathVariable(name = "id") Long id,@RequestBody VacancyDTO vacancyDTO){
        return vacancyService.updateVacancy(id, vacancyDTO);
    }
    @GetMapping("/search/{name}")
    List<VacancyDTO> getVacancyByName(@PathVariable(name = "name") String vacancyName){
        return vacancyService.getVacancyByName(vacancyName);
    }
    @DeleteMapping("/{id}")
    void deleteVacancy(@PathVariable(name = "id") Long id){
        vacancyService.deleteVacancy(id);
    }

}
