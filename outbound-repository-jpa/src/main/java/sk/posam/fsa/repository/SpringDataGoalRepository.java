package sk.posam.fsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.posam.fsa.entity.GoalEntity;

import java.util.List;

public interface SpringDataGoalRepository extends JpaRepository<GoalEntity, Long> {
    List<GoalEntity> findByAthleteId(Long athleteId);
}
