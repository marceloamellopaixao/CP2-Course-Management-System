package br.com.fiap.main.repository;

import br.com.fiap.main.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Teacher, Long> {
}
