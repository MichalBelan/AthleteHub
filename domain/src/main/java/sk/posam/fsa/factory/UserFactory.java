package sk.posam.fsa.factory;

import sk.posam.fsa.Athlete;
import sk.posam.fsa.Coach;
import sk.posam.fsa.User;
import sk.posam.fsa.UserRole;

public class UserFactory {
    public static User createAthlete(Long id, String name, String email, String password, UserRole sportType) {
        return new Athlete(id, name, email, password, sportType);
    }

    public static User createCoach(Long id, String name, String email, String password, UserRole certification) {
        return new Coach(id, name, email, password, certification);
    }
}