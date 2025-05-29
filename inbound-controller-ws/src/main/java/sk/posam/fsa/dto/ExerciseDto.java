package sk.posam.fsa.dto;

public class ExerciseDto {
    private String name;
    private int repetitions;
    private int sets;

    // Gettery a settery
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRepetitions() { return repetitions; }
    public void setRepetitions(int repetitions) { this.repetitions = repetitions; }

    public int getSets() { return sets; }
    public void setSets(int sets) { this.sets = sets; }
}
