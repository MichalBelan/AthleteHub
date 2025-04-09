package sk.posam.fsa.ports;

import sk.posam.fsa.TrainingPlan;

import java.util.List;

public interface TrainingPlanRepository {
    void create(TrainingPlan plan);
    TrainingPlan read(Long id);
    List<TrainingPlan> findByAthleteId(Long athleteId);
}
