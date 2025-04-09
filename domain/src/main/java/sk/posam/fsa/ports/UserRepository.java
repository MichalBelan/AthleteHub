package sk.posam.fsa.ports;

import sk.posam.fsa.User;

import java.util.Optional;

public interface UserRepository {
    void create(User user);
    Optional<User> read(Long id);
    void update(User user);
    void delete(Long id);
    Optional<User> findByEmail(String email);
}
