package sk.posam.fsa.service;

import sk.posam.fsa.TrainingPlan;

public class TrainingPlanService {
    public boolean isValid(TrainingPlan plan) {
        return plan != null && plan.getExercises() != null && !plan.getExercises().isEmpty();
    }
}



