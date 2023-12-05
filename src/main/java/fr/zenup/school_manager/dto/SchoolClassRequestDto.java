package fr.zenup.school_manager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class SchoolClassRequestDto {

	protected String name;

	protected String grade;
}
