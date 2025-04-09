package sk.posam.fsa;

public class Athlete extends User {
    private String sportType;

    public Athlete(Long id, String name, String email,String password ,UserRole role) {
        super(id, name, email,password ,UserRole.ATHLETE);
        this.sportType = sportType;
    }


    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }
}