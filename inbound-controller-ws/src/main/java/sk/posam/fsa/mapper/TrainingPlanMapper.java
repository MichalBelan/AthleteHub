package sk.posam.fsa.mapper;

import org.springframework.stereotype.Component;
import sk.posam.fsa.Exercise;
import sk.posam.fsa.TrainingPlan;
import sk.posam.fsa.dto.ExerciseDto;
import sk.posam.fsa.dto.TrainingPlanDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainingPlanMapper {

    public TrainingPlanDto toDto(TrainingPlan plan) {
        TrainingPlanDto dto = new TrainingPlanDto();
        dto.setId(plan.getId());
        dto.setTitle(plan.getTitle());
        dto.setDescription(plan.getDescription());
        dto.setSchedule(plan.getSchedule());
        dto.setAthleteId(plan.getAthleteId());
        dto.setExercises(
                plan.getExercises() != null
                        ? plan.getExercises().stream().map(this::toDto).collect(Collectors.toList())
                        : List.of()
        );
        return dto;
    }

    public TrainingPlan toDomain(TrainingPlanDto dto) {
        TrainingPlan plan = new TrainingPlan();
        plan.setId(dto.getId());
        plan.setTitle(dto.getTitle());
        plan.setDescription(dto.getDescription());
        plan.setSchedule(dto.getSchedule());
        plan.setAthleteId(dto.getAthleteId());
        plan.setExercises(
                dto.getExercises() != null
                        ? dto.getExercises().stream().map(this::toDomain).collect(Collectors.toList())
                        : List.of()
        );
        return plan;
    }


    private ExerciseDto toDto(Exercise e) {
        ExerciseDto dto = new ExerciseDto();
        dto.setName(e.getName());
        dto.setRepetitions(e.getRepetitions());
        dto.setSets(e.getSets());
        return dto;
    }

    private Exercise toDomain(ExerciseDto dto) {
        return new Exercise(dto.getName(), dto.getRepetitions(), dto.getSets());
    }
}
