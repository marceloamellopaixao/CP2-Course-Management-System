package br.com.fiap.main.model;

import br.com.fiap.main.controller.dto.registration.RegistrationDTO;
import jakarta.persistence.*;

public class Registration {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
//
//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;

//    public Registration(RegistrationDTO registrationDTO){
//        this.course = registrationDTO.courseId();
//        this.student = registrationDTO.studentId();
//    }
}
