package com.chanbar.backend133_chanbar.services.Impls;

import com.chanbar.backend133_chanbar.DTOs.request.CourseRequestDTO;
import com.chanbar.backend133_chanbar.DTOs.response.CourseResponseDTO;
import com.chanbar.backend133_chanbar.models.Course;
import com.chanbar.backend133_chanbar.models.SubCategory;
import com.chanbar.backend133_chanbar.repositories.CourseRepository;
import com.chanbar.backend133_chanbar.repositories.SubCategoryRepository;
import com.chanbar.backend133_chanbar.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;
    private final SubCategoryRepository subCategoryRepository;

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Optional<SubCategory> subCategory = subCategoryRepository.findBySubCategoryName(courseRequestDTO.getSubCategory());

        if(subCategory.isPresent()){
            Course course = new Course();
            course.setCourseName(courseRequestDTO.getCourseName());
            course.setCourseDescription(courseRequestDTO.getCourseDescription());
            course.setCoursePrice(courseRequestDTO.getCoursePrice());
            course.setCourseDiscount(courseRequestDTO.getCourseDiscount());
            course.setImgCourse(courseRequestDTO.getImgCourse());
            course.setIsLiked(courseRequestDTO.getIsLiked());
            course.setSubCategory(subCategory.get());

            courseRepository.save(course);

            CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
            courseResponseDTO.setCourseName(course.getCourseName());
            courseResponseDTO.setCourseDescription(course.getCourseDescription());
            courseResponseDTO.setCoursePrice(course.getCoursePrice());
            courseResponseDTO.setCourseDiscount(course.getCourseDiscount());
            courseResponseDTO.setImgCourse(course.getImgCourse());
            courseResponseDTO.setIsLiked(course.getIsLiked());
            courseResponseDTO.setSubCategory(course.getSubCategory().getSubCategoryName());

            return courseResponseDTO;
        }

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
