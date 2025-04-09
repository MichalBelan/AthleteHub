package sk.posam.fsa;

import java.time.LocalDate;
import java.util.List;

public class TrainingPlan {
    private Long id;
    private String title;
    private String description;
    private List<Exercise> exercises;
    private Long athleteId;
    private LocalDate schedule;

    public TrainingPlan(String title, String description, List<Exercise> exercises, Long athleteId) {
        this.title = title;
        this.description = description;
        this.exercises = exercises;
        this.athleteId = athleteId;
    }
    public TrainingPlan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }
    public LocalDate getSchedule() {
        return schedule;
    }
    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }
}
