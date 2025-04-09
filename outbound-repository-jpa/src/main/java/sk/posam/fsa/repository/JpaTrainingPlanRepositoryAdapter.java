package sk.posam.fsa.repository;

import org.springframework.stereotype.Repository;
import sk.posam.fsa.TrainingPlan;
import sk.posam.fsa.mapper.EntityDomainMapper;
import sk.posam.fsa.ports.TrainingPlanRepository;
import sk.posam.fsa.repository.SpringDataTrainingPlanRepository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaTrainingPlanRepositoryAdapter implements TrainingPlanRepository {

    private final SpringDataTrainingPlanRepository repository;

    public JpaTrainingPlanRepositoryAdapter(SpringDataTrainingPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TrainingPlan plan) {
        repository.save(EntityDomainMapper.toEntity(plan));
    }

    @Override
    public TrainingPlan read(Long id) {
        return repository.findById(id)
                .map(EntityDomainMapper::toDomain)
                .orElseThrow();
    }

    @Override
    public List<TrainingPlan> findByAthleteId(Long athleteId) {
        return repository.findByAthleteId(athleteId)
                .stream()
                .map(EntityDomainMapper::toDomain)
                .collect(Collectors.toList());
    }
}