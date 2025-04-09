package sk.posam.fsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.entity.UserEntity;

import java.util.Optional;


public interface SpringDataUserRepository  extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
