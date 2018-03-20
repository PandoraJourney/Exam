package lt.akademija.service;

import lt.akademija.model.entity.SimpleUser;
import lt.akademija.repository.SimpleUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private SimpleUserRepository repo;

    @Transactional
    public List<SimpleUser> getAll() {
        return repo.findAll();
    }

    @Transactional
    public SimpleUser getOne(Long id) {
        return repo.getOne(id);
    }

    @Transactional
    public void create(SimpleUser dto) {
        SimpleUser entity = new SimpleUser();
        BeanUtils.copyProperties(dto, entity);
        repo.save(entity);
    }

    @Transactional
    public void update(Long id, SimpleUser dto) {
        SimpleUser entity = repo.getOne(id);
        if (entity != null) {
            BeanUtils.copyProperties(dto, entity, "id");
            repo.save(entity);
        }
    }

    @Transactional
    public void delete(Long id) {
        repo.delete(id);
    }
}
