package sk.posam.fsa.mapper;

import org.springframework.stereotype.Component;
import sk.posam.fsa.Performance;
import sk.posam.fsa.dto.PerformanceDto;

@Component
public class PerformanceMapper {

    public PerformanceDto toDto(Performance p) {
        PerformanceDto dto = new PerformanceDto();
        dto.setId(p.getId());
        dto.setAthleteId(p.getAthleteId());
        dto.setExerciseId(p.getExerciseId());
        dto.setResult(p.getResult());
        return dto;
    }

    public Performance toDomain(PerformanceDto dto) {
        Performance p = new Performance();
        p.setId(dto.getId());
        p.setAthleteId(dto.getAthleteId());
        p.setExerciseId(dto.getExerciseId());
        p.setResult(dto.getResult());
        return p;
    }
}
