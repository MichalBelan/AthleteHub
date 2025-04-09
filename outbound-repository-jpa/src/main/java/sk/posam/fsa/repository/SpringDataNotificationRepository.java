package sk.posam.fsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.posam.fsa.entity.NotificationEntity;

import java.util.List;

public interface SpringDataNotificationRepository extends JpaRepository<NotificationEntity, Long> {
    List<NotificationEntity> findByUserId(Long userId);
}
