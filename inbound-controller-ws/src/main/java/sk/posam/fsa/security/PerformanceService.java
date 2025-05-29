package sk.posam.fsa.security;

import org.springframework.stereotype.Service;
import sk.posam.fsa.Performance;
import sk.posam.fsa.ports.PerformanceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceService {

    private final PerformanceRepository repository;

    public PerformanceService(PerformanceRepository repository) {
        this.repository = repository;
    }

    public void create(Performance performance) {
        repository.create(performance);
    }

    public Optional<Performance> read(Long id) {
        return repository.read(id);
    }

    public void update(Performance performance) {
        repository.update(performance);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public List<Performance> findByAthleteId(Long athleteId) {
        return repository.findByAthleteId(athleteId);
    }
}
