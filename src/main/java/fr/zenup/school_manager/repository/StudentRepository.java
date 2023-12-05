package fr.zenup.school_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.zenup.school_manager.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
