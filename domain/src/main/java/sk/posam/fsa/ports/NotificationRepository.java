package sk.posam.fsa.ports;

import sk.posam.fsa.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {
    void create(Notification notification);
    Optional<Notification> read(Long id);
    void update(Notification notification);
    void delete(Long id);
    List<Notification> findByUserId(Long userId);
}
