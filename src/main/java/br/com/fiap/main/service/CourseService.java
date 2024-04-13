package br.com.fiap.main.service;


import br.com.fiap.main.controller.dto.course.CourseDTO;
import br.com.fiap.main.controller.dto.teacher.TeacherDTO;
import br.com.fiap.main.exception.AssociatedEntitiesNotPersistedException;
import br.com.fiap.main.model.Course;
import br.com.fiap.main.model.Teacher;
import br.com.fiap.main.repository.CourseRepository;
import br.com.fiap.main.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, TeacherRepository teacherRepository){
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }



    @Transactional
    public Course createCourse(CourseDTO courseDTO) {
        for (TeacherDTO teacherDTO : courseDTO.teacher()) {
            Teacher teacher = teacherRepository.findById(teacherDTO.id())
                    .orElseThrow(() -> new AssociatedEntitiesNotPersistedException(
                            "One or more associated teachers are not persisted: " + teacherDTO.id()));
        }

        // Salva o curso
        Course course = new Course(courseDTO);
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Transactional
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso com o ID: " + id + " não foi encontrado!!"));
    }

    @Transactional
    public Course updateCourse(Long id, CourseDTO courseDTO) {
        Course existingCourse = getCourseById(id);
        existingCourse.setName(courseDTO.name());
        existingCourse.setDescription(courseDTO.description());
        existingCourse.setInitDate(courseDTO.initDate());
        return courseRepository.save(existingCourse);
    }

    @Transactional
    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }
}
