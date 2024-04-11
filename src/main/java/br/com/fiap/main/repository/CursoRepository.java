package br.com.fiap.main.repository;

import br.com.fiap.main.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Course, Long> {
}
