package com.chanbar.backend133_chanbar.services;

import com.chanbar.backend133_chanbar.DTOs.CategoryDTO;
import com.chanbar.backend133_chanbar.DTOs.VacancyDTO;

import java.util.List;

public interface IVacancyService {
    VacancyDTO createVacancy(VacancyDTO vacancyDTO);
    List<VacancyDTO> getAllVacancies();
    VacancyDTO getVacancyById(Long id);
    List<VacancyDTO> getVacancyByName(String vacancyName);
    VacancyDTO updateVacancy(Long id, VacancyDTO vacancyDTO);
    void deleteVacancy(Long id);
}
