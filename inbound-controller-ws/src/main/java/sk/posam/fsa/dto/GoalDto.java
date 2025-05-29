package sk.posam.fsa.dto;

import java.time.LocalDate;

public class GoalDto {
    private Long id;
    private Long athleteId;
    private String description;
    private boolean achieved;
    private LocalDate targetDate;

    // Gettery a settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAthleteId() { return athleteId; }
    public void setAthleteId(Long athleteId) { this.athleteId = athleteId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isAchieved() { return achieved; }
    public void setAchieved(boolean achieved) { this.achieved = achieved; }

    public LocalDate getTargetDate() { return targetDate; }
    public void setTargetDate(LocalDate targetDate) { this.targetDate = targetDate; }
}
