package sk.posam.fsa.mapper;

import org.springframework.stereotype.Component;
import sk.posam.fsa.Goal;
import sk.posam.fsa.dto.GoalDto;

@Component
public class GoalMapper {

    public Goal toDomain(GoalDto dto) {
        Goal goal = new Goal();
        goal.setId(dto.getId());
        goal.setAthleteId(dto.getAthleteId());
        goal.setDescription(dto.getDescription());
        goal.setAchieved(dto.isAchieved());
        goal.setTargetDate(dto.getTargetDate());
        return goal;
    }

    public GoalDto toDto(Goal goal) {
        GoalDto dto = new GoalDto();
        dto.setId(goal.getId());
        dto.setAthleteId(goal.getAthleteId());
        dto.setDescription(goal.getDescription());
        dto.setAchieved(goal.isAchieved());
        dto.setTargetDate(goal.getTargetDate());
        return dto;
    }
}
