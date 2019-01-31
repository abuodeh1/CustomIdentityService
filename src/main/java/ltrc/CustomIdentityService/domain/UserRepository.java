package ltrc.CustomIdentityService.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
/**
 * Created by ashlah on 28/07/17.
 */
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findById(String id);
}
