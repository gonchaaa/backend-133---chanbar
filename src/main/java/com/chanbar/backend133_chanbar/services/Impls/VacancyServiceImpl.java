package com.chanbar.backend133_chanbar.services.Impls;

import com.chanbar.backend133_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend133_chanbar.models.Vacancy;
import com.chanbar.backend133_chanbar.repositories.VacancyRepository;
import com.chanbar.backend133_chanbar.services.IVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements IVacancyService {

    private final VacancyRepository vacancyRepository;

    @Override
    public VacancyDTO createVacancy(VacancyDTO vacancyDTO) {

        Vacancy vacancy = new Vacancy();
        vacancy.setVacancyName(vacancyDTO.getVacancyName());
        vacancy.setDescription(vacancyDTO.getDecription());

        vacancyRepository.save(vacancy);

        VacancyDTO vacancyDTO1 = new VacancyDTO();
        vacancyDTO1.setVacancyName(vacancy.getVacancyName());
        vacancyDTO1.setDecription(vacancy.getDescription());

        return vacancyDTO1;
    }

    @Override
    public List<VacancyDTO> getAllVacancies() {

        List<Vacancy> vacancyList = vacancyRepository.findAll();

        List<VacancyDTO> vacancyDTOList = new ArrayList<>();

        for (Vacancy vacancy : vacancyList) {
            VacancyDTO vacancyDTO = new VacancyDTO();
            vacancyDTO.setVacancyName(vacancy.getVacancyName());
            vacancyDTO.setDecription(vacancy.getDescription());
            vacancyDTOList.add(vacancyDTO);
        }

        return vacancyDTOList;
    }

    @Override
    public VacancyDTO getVacancyById(Long id) {

        Optional<Vacancy> vacancy = vacancyRepository.findById(id);

        if(vacancy.isPresent()) {
            VacancyDTO vacancyDTO = new VacancyDTO();
            vacancyDTO.setVacancyName(vacancy.get().getVacancyName());
            vacancyDTO.setDecription(vacancy.get().getDescription());
            return vacancyDTO;
        }
        return null;
    }

    @Override
    public List<VacancyDTO> getVacancyByName(String vacancyName) {

        Optional<List<Vacancy>> vacancyList = vacancyRepository.findByVacancyName(vacancyName);

        if (vacancyList.isPresent()){
            List<VacancyDTO> vacancyDTOList = new ArrayList<>();
            for (Vacancy vacancy : vacancyList.get()) {
                VacancyDTO vacancyDTO = new VacancyDTO();
                vacancyDTO.setVacancyName(vacancy.getVacancyName());
                vacancyDTO.setDecription(vacancy.getDescription());
                vacancyDTOList.add(vacancyDTO);
            }
            return vacancyDTOList;
        }

        return null;
    }

    @Override
    public VacancyDTO updateVacancy(Long id, VacancyDTO vacancyDTO) {
        Optional<Vacancy> vacancy = vacancyRepository.findById(id);

        if(vacancy.isPresent()) {
            Vacancy vacancy1 = vacancy.get();
            vacancy1.setVacancyName(vacancyDTO.getVacancyName());
            vacancy1.setDescription(vacancyDTO.getDecription());

            vacancyRepository.save(vacancy1);

            VacancyDTO vacancyDTO1 = new VacancyDTO();
            vacancyDTO1.setVacancyName(vacancy1.getVacancyName());
            vacancyDTO1.setDecription(vacancy1.getDescription());
            return vacancyDTO1;
        }

        return null;
    }

    @Override
    public void deleteVacancy(Long id) {
        Optional<Vacancy> vacancy = vacancyRepository.findById(id);

        if(vacancy.isPresent()) {
            vacancyRepository.deleteById(id);
        }

    }
}
