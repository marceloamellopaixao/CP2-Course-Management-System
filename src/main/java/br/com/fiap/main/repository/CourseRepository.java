package br.com.fiap.main.repository;

import br.com.fiap.main.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
