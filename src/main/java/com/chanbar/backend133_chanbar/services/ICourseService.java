package com.chanbar.backend133_chanbar.services;

import com.chanbar.backend133_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend133_chanbar.DTOs.request.CourseRequestDTO;
import com.chanbar.backend133_chanbar.DTOs.response.CourseResponseDTO;

import java.util.List;

public interface ICourseService {
    CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO);
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO getCourseById(Long id);
    List<CourseResponseDTO> getCourseByName(String courseName);
    List<CourseResponseDTO> getCoursesBySubCategory(String subCategory);
    CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO);
    void deleteCourse(Long id);
}
