package br.com.fiap.main.repository;

import br.com.fiap.main.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
