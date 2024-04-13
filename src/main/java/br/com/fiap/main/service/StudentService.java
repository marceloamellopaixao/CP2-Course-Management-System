package br.com.fiap.main.service;

import br.com.fiap.main.controller.dto.course.CourseDTO;
import br.com.fiap.main.controller.dto.student.StudentDTO;
import br.com.fiap.main.model.Course;
import br.com.fiap.main.model.Student;
import br.com.fiap.main.repository.StudentRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    // Post Mapping
    @Transactional
    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student(studentDTO);
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Transactional
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno com o ID: " + id + " não foi encontrado!!"));
    }

    @Transactional
    public Student updateStudent(Long id, StudentDTO studentDTO) {
        Student existingStudent = getStudentById(id);
        existingStudent.setName(studentDTO.name());
        existingStudent.setEmail(studentDTO.email());
        existingStudent.setResidenceCountry(studentDTO.residenceCountry());
        return repository.save(existingStudent);
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        repository.delete(student);
    }

}
