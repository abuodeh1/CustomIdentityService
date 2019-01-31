package ltrc.CustomIdentityService.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ltrc.CustomIdentityService.domain.User;
import ltrc.CustomIdentityService.domain.UserRepository;

/**
 * Created by ashlah on 28/07/17.
 */
@Service
@Transactional
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findById(String id) {
    	Optional<User> user = repository.findById(id);
        return (user.isPresent()? user.get() : null);
    }

    public Collection<User> findAll() {
        return (Collection<User>) repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }
}
