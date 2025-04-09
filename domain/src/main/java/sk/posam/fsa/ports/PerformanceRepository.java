package sk.posam.fsa.ports;

import sk.posam.fsa.Performance;

import java.util.List;
import java.util.Optional;

public interface PerformanceRepository {
    void create(Performance performance);
    Optional<Performance> read(Long id);
    void update(Performance performance);
    void delete(Long id);
    List<Performance> findByAthleteId(Long athleteId);
}
