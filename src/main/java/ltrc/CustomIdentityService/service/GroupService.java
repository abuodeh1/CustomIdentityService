package ltrc.CustomIdentityService.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ltrc.CustomIdentityService.domain.Group;
import ltrc.CustomIdentityService.domain.GroupRepository;

/**
 * Created by ashlah on 28/07/17.
 */
@Service
@Transactional
public class GroupService {

    @Autowired
    private GroupRepository repository;

    public Group findById(String id) {
    	Optional<Group> group = repository.findById(id);
        return (group.isPresent()? group.get() : null);
    }

    public Collection<Group> findAll() {
        return (Collection<Group>) repository.findAll();
    }

    public Group save(Group group) {
        return repository.save(group);
    }
}
