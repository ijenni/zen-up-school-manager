package fr.zenup.school_manager.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.zenup.school_manager.dto.StudentDto;
import fr.zenup.school_manager.dto.StudentRequestDto;
import fr.zenup.school_manager.service.StudentService;

@RestController
@RequestMapping("/api/school-classes/{schoolClassId}/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	@ResponseStatus(CREATED)
	public StudentDto create(@PathVariable Long schoolClassId, @RequestBody StudentRequestDto studentRequestDto) {

		return studentService.add(schoolClassId, studentRequestDto);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<StudentDto> readAll(@PathVariable Long schoolClassId) {

		return studentService.read(schoolClassId);
	}
}
