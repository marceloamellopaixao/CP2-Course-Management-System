package br.com.fiap.main.service;

import br.com.fiap.main.controller.dto.student.StudentDTO;
import br.com.fiap.main.model.Student;
import br.com.fiap.main.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final AlunoRepository repository;

    @Autowired
    private StudentService(AlunoRepository repository){
        this.repository = repository;
    }

    // Post Mapping
    public Student createStudent(StudentDTO studentDTO){
        return repository.save(new Student(studentDTO));
    }

    // Get Mapping

}
