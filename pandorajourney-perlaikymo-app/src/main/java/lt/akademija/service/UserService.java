package lt.akademija.service;

import lt.akademija.model.entity.User;
import lt.akademija.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private static Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository repo;

    @PostConstruct
    public void init(){
        logger.info("I'm here for long");
    }

    @PreDestroy
    public void dest(){
        logger.info("See you later");
    }

    @Transactional
    public List<User> getAll() {
        return repo.findAll();
    }

    @Transactional
    public User getOne(Long id) {
        return repo.getOne(id);
    }

    @Transactional
    public void create(User dto) {
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        repo.save(entity);
    }

    @Transactional
    public void update(Long id, User dto) {
        User entity = repo.getOne(id);
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
