package sk.posam.fsa;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Performance {
    private Long id;
    private Long athleteId;
    private String metric;
    private double value;
    private LocalDate date;
    private Long exerciseId;
    private BigDecimal result;


    public Performance() {
    }

    public Performance(Long athleteId, String metric, double value, LocalDate date) {
        this.athleteId = athleteId;
        this.metric = metric;
        this.value = value;
        this.date = date;
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

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Long getExerciseId() {
        return exerciseId;
    }
    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }
    public BigDecimal getResult() {
        return result;
    }
    public void setResult(BigDecimal result) {
        this.result = result;
    }
}
