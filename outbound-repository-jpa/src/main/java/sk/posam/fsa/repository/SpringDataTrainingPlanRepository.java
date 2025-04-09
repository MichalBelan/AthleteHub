package sk.posam.fsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.posam.fsa.entity.TrainingPlanEntity;

import java.util.List;

public interface SpringDataTrainingPlanRepository extends JpaRepository<TrainingPlanEntity, Long> {
    List<TrainingPlanEntity> findByAthleteId(Long athleteId);
}
