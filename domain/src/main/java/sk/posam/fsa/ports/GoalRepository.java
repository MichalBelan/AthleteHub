package sk.posam.fsa.ports;

import sk.posam.fsa.Goal;

import java.util.List;
import java.util.Optional;

public interface GoalRepository {
    void create(Goal goal);
    Optional<Goal> read(Long id);
    void update(Goal goal);
    void delete(Long id);
    List<Goal> findByAthleteId(Long athleteId);
}
