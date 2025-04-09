package sk.posam.fsa.repository;

import org.springframework.stereotype.Repository;
import sk.posam.fsa.User;
import sk.posam.fsa.mapper.EntityDomainMapper;
import sk.posam.fsa.ports.UserRepository;

import java.util.Optional;

@Repository
public class JpaUserRepositoryAdapter implements UserRepository {
    private final SpringDataUserRepository repository;

    public JpaUserRepositoryAdapter(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(User user) {
        repository.save(EntityDomainMapper.toEntity(user));
    }

    @Override
    public Optional<User> read(Long id) {
        return repository.findById(id).map(EntityDomainMapper::toDomain);
    }

    @Override
    public void update(User user) {
        repository.save(EntityDomainMapper.toEntity(user));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(EntityDomainMapper::toDomain);
    }
}
