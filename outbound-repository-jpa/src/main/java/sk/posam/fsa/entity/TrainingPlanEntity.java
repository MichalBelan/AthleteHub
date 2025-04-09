package sk.posam.fsa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "training_plan")
public class TrainingPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate schedule;
    private Long athleteId;


    // Gettery a settery
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

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }
    public Long getAthleteId() {
        return athleteId;
    }
    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }
}
