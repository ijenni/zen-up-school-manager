package fr.zenup.school_manager.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.zenup.school_manager.dto.SchoolClassDto;
import fr.zenup.school_manager.dto.SchoolClassRequestDto;
import fr.zenup.school_manager.entity.SchoolClass;
import fr.zenup.school_manager.repository.SchoolClassRepository;

@Service
public class SchoolClassService {

	@Autowired
	private SchoolClassRepository schoolClassRepository;

	@Autowired
	private ModelMapper mapper;

	public SchoolClassDto add(SchoolClassRequestDto schoolClassRequestDto) {

		SchoolClass schoolClass = mapper.map(schoolClassRequestDto, SchoolClass.class);

		return mapper.map(schoolClassRepository.save(schoolClass), SchoolClassDto.class);
	}
}
