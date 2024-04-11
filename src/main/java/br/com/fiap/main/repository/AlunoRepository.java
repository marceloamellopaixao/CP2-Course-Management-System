package br.com.fiap.main.repository;

import br.com.fiap.main.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Student, Long> {
}
