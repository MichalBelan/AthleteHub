package sk.posam.fsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.posam.fsa.entity.PerformanceEntity;

import java.util.List;

public interface SpringDataPerformanceRepository extends JpaRepository<PerformanceEntity, Long> {
    List<PerformanceEntity> findByAthleteId(Long athleteId);

}
