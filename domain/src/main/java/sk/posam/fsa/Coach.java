package sk.posam.fsa;

public class Coach extends User {
    private String certification;

    public Coach(Long id, String name, String email, String password, UserRole role) {
        super(id, name, email, password, UserRole.COACH);
        this.certification = certification;
    }


    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }
}