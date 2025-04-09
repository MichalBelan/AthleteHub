package sk.posam.fsa.repository;

import org.springframework.stereotype.Repository;
import sk.posam.fsa.Performance;
import sk.posam.fsa.mapper.EntityDomainMapper;
import sk.posam.fsa.ports.PerformanceRepository;
import sk.posam.fsa.repository.SpringDataPerformanceRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaPerformanceRepositoryAdapter implements PerformanceRepository {

    private final SpringDataPerformanceRepository repository;

    public JpaPerformanceRepositoryAdapter(SpringDataPerformanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Performance performance) {
        repository.save(EntityDomainMapper.toEntity(performance));
    }

    @Override
    public Optional<Performance> read(Long id) {
        return repository.findById(id).map(EntityDomainMapper::toDomain);
    }

    @Override
    public void update(Performance performance) {
        repository.save(EntityDomainMapper.toEntity(performance));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Performance> findByAthleteId(Long athleteId) {
        return repository.findByAthleteId(athleteId)
                .stream()
                .map(EntityDomainMapper::toDomain)
                .collect(Collectors.toList());
    }
}