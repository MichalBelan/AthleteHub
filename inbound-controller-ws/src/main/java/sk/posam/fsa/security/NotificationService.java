package sk.posam.fsa.security;

import org.springframework.stereotype.Service;
import sk.posam.fsa.Notification;
import sk.posam.fsa.ports.NotificationRepository;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public void create(Notification notification) {
        repository.create(notification);
    }

    public List<Notification> findByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public void markAsRead(Long id) {
        repository.read(id).ifPresent(notification -> {
            notification.markAsRead();
            repository.update(notification);
        });
    }
}
