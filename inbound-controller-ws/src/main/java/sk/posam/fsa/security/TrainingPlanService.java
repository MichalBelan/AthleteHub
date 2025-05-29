package sk.posam.fsa.security;

import org.springframework.stereotype.Service;
import sk.posam.fsa.TrainingPlan;
import sk.posam.fsa.ports.TrainingPlanRepository;

import java.util.List;

@Service
public class TrainingPlanService {

    private final TrainingPlanRepository repository;

    public TrainingPlanService(TrainingPlanRepository repository) {
        this.repository = repository;
    }

    public void create(TrainingPlan plan) {
        repository.create(plan);
    }

    public TrainingPlan findById(Long id) {
        return repository.read(id);
    }

    public List<TrainingPlan> findByAthlete(Long athleteId) {
        return repository.findByAthleteId(athleteId);
    }
}