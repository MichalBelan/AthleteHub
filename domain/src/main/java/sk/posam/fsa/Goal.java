package sk.posam.fsa;

import java.time.LocalDate;

public class Goal {
    private Long id;
    private Long athleteId;
    private String description;
    private boolean achieved;
    private LocalDate targetDate;


    public Goal() {
    }

    public Goal(Long athleteId, String description,LocalDate targetDate) {
        this.athleteId = athleteId;
        this.description = description;
        this.achieved = false;
        this.targetDate = targetDate;
    }

    public void markAsAchieved() {
        this.achieved = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }
    public LocalDate getTargetDate() {
        return targetDate;
    }
    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}
