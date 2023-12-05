package fr.zenup.school_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.zenup.school_manager.entity.SchoolClass;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

}
