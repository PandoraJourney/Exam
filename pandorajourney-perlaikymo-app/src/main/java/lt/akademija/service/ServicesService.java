package lt.akademija.service;

import lt.akademija.model.dto.ServiceDTO;
import lt.akademija.model.entity.Services;
import lt.akademija.repository.ServicesRepository;
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
public class ServicesService {

    private static Logger logger = LogManager.getLogger(ServicesService.class);

    @Autowired
    private ServicesRepository repo;
//
//    @Autowired(required = false)
//    private ProductDTO dto;

    @PostConstruct
    public void init(){
        logger.info("I'm here for long");
    }

    @PreDestroy
    public void dest(){
        logger.info("See you later");
    }

    @Transactional
    public List<? extends Services> getAll() {
        return repo.findAll();
    }

    @Transactional
    public Services getOne(Long id) {
        return repo.getOne(id);
    }

    @Transactional
    public Long serviceTaken(Long servId)
    {
        return repo.countById(servId);
    }

    @Transactional
    public void create(ServiceDTO dto) {
//        if(this.dto != null)
//        {
//            logger.info("DTO is still alive");
//        }
        Services oldObject = repo.findOneByName(dto.getName());
        if(oldObject != null)
        {
            logger.info("Object with name: "+ dto.getName()+"already exists");
            throw new IllegalArgumentException("Object with name: "+ dto.getName()+"already exists");
        }
        Services entity = new Services();
        BeanUtils.copyProperties(dto, entity);
        repo.save(entity);
    }

    @Transactional
    public void update(Long id, ServiceDTO dto) {
        Services entity = repo.getOne(id);
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
