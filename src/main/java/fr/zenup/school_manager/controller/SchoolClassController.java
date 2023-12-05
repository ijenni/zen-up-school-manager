package fr.zenup.school_manager.controller;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.zenup.school_manager.dto.SchoolClassDto;
import fr.zenup.school_manager.dto.SchoolClassRequestDto;
import fr.zenup.school_manager.service.SchoolClassService;

@RestController
@RequestMapping("/api/school-classes")
public class SchoolClassController {

	@Autowired
	private SchoolClassService schoolClassService;

	@PostMapping
	@ResponseStatus(CREATED)
	public SchoolClassDto create(@RequestBody SchoolClassRequestDto schoolClassRequestDto) {

		return schoolClassService.add(schoolClassRequestDto);
	}
}
