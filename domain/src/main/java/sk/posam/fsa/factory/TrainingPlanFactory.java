package sk.posam.fsa.factory;

import sk.posam.fsa.Exercise;
import sk.posam.fsa.TrainingPlan;

import java.util.List;

public class TrainingPlanFactory {
    public static TrainingPlan create(String title, String description, List<Exercise> exercises, Long athleteId) {
        return new TrainingPlan(title, description, exercises, athleteId);
    }
}
