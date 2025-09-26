package com.chanbar.backend133_chanbar.services.Impls;

import com.chanbar.backend133_chanbar.DTOs.request.CourseRequestDTO;
import com.chanbar.backend133_chanbar.DTOs.response.CourseResponseDTO;
import com.chanbar.backend133_chanbar.repositories.CourseRepository;
import com.chanbar.backend133_chanbar.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        return null;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return List.of();
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        return null;
    }

    @Override
    public List<CourseResponseDTO> getCourseByName(String courseName) {
        return List.of();
    }

    @Override
    public List<CourseResponseDTO> getCoursesBySubCategory(String subCategory) {
        return List.of();
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }
}
