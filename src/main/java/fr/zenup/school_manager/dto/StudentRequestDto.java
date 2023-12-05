package fr.zenup.school_manager.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class StudentRequestDto {

	protected String familyName;

	protected String personalName;

	protected LocalDate birthDate;
}
