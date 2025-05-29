package sk.posam.fsa.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrainingPlanDto {
    private Long id;
    private String title;
    private String description;
    private Long athleteId;
    private LocalDate schedule;
    private List<ExerciseDto> exercises= new ArrayList<>();

    // Gettery a settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getAthleteId() { return athleteId; }
    public void setAthleteId(Long athleteId) { this.athleteId = athleteId; }

    public LocalDate getSchedule() { return schedule; }
    public void setSchedule(LocalDate schedule) { this.schedule = schedule; }

    public List<ExerciseDto> getExercises() { return exercises; }
    public void setExercises(List<ExerciseDto> exercises) { this.exercises = exercises; }
}
