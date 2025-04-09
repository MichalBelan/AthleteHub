package sk.posam.fsa.repository;

import org.springframework.stereotype.Repository;
import sk.posam.fsa.Goal;
import sk.posam.fsa.mapper.EntityDomainMapper;
import sk.posam.fsa.ports.GoalRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaGoalRepositoryAdapter implements GoalRepository {

    private final SpringDataGoalRepository repository;

    public JpaGoalRepositoryAdapter(SpringDataGoalRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Goal goal) {
        repository.save(EntityDomainMapper.toEntity(goal));
    }

    @Override
    public Optional<Goal> read(Long id) {
        return repository.findById(id).map(EntityDomainMapper::toDomain);
    }

    @Override
    public void update(Goal goal) {
        repository.save(EntityDomainMapper.toEntity(goal));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Goal> findByAthleteId(Long athleteId) {
        return repository.findByAthleteId(athleteId)
                .stream()
                .map(EntityDomainMapper::toDomain)
                .collect(Collectors.toList());
    }
}
