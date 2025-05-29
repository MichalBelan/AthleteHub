package sk.posam.fsa.security;

import org.springframework.stereotype.Service;
import sk.posam.fsa.Goal;
import sk.posam.fsa.ports.GoalRepository;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository repository;

    public GoalService(GoalRepository repository) {
        this.repository = repository;
    }

    public void create(Goal goal) {
        repository.create(goal);
    }

    public List<Goal> findByAthlete(Long athleteId) {
        return repository.findByAthleteId(athleteId);
    }


}
