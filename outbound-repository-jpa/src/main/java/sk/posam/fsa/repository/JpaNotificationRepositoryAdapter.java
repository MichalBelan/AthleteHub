package sk.posam.fsa.repository;

import org.springframework.stereotype.Repository;
import sk.posam.fsa.Notification;
import sk.posam.fsa.mapper.EntityDomainMapper;
import sk.posam.fsa.ports.NotificationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaNotificationRepositoryAdapter implements NotificationRepository {
    private final SpringDataNotificationRepository repository;

    public JpaNotificationRepositoryAdapter(SpringDataNotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Notification notification) {
        repository.save(EntityDomainMapper.toEntity(notification));
    }

    @Override
    public Optional<Notification> read(Long id) {
        return repository.findById(id).map(EntityDomainMapper::toDomain);
    }

    @Override
    public void update(Notification notification) {
        repository.save(EntityDomainMapper.toEntity(notification));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Notification> findByUserId(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(EntityDomainMapper::toDomain)
                .collect(Collectors.toList());
    }
}
