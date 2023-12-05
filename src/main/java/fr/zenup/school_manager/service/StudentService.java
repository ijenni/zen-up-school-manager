package fr.zenup.school_manager.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import fr.zenup.school_manager.dto.StudentDto;
import fr.zenup.school_manager.dto.StudentRequestDto;
import fr.zenup.school_manager.entity.SchoolClass;
import fr.zenup.school_manager.entity.Student;
import fr.zenup.school_manager.repository.SchoolClassRepository;
import fr.zenup.school_manager.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SchoolClassRepository schoolClassRepository;

	@Autowired
	private ModelMapper mapper;

	public StudentDto add(Long schoolClassId, StudentRequestDto studentRequestDto) {

		SchoolClass schoolClass = schoolClassRepository.findById(schoolClassId).orElseThrow(
				() -> new RuntimeException(String.format("Unable to find school class with id %d", schoolClassId)));

		Student student = mapper.map(studentRequestDto, Student.class);
		student.setSchoolClass(schoolClass);

		return mapper.map(studentRepository.save(student), StudentDto.class);
	}

	public List<StudentDto> read(Long schoolClassId) {

		SchoolClass schoolClass = schoolClassRepository.findById(schoolClassId).orElseThrow(
				() -> new RuntimeException(String.format("Unable to find school class with id %d", schoolClassId)));

		return studentRepository.findAll( //
				Example.of( //
						Student.builder() //
								.schoolClass(schoolClass) //
								.build() //
				)) //
				.stream() //
				.map(student -> mapper.map(student, StudentDto.class)) //
				.toList();
	}
}
