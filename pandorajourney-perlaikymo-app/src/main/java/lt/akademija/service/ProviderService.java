package lt.akademija.service;

import lt.akademija.model.dto.ProviderDTO;
import lt.akademija.model.entity.Provider;
import lt.akademija.model.entity.Services;
import lt.akademija.repository.ProviderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
public class ProviderService {

    private static Logger logger = LogManager.getLogger(ProviderService.class);

    @Autowired
    private ProviderRepository repo;

    @Autowired
    private ServicesService servService;

    @PostConstruct
    public void init(){
        logger.info("I'm here for long");
    }

    @PreDestroy
    public void dest(){
        logger.info("See you later, alligater");
    }

    @Transactional
    public List<Provider> getAll() {
        return repo.findAll();
    }

    @Transactional
    public Provider getOne(Long id) {
        return repo.getOne(id);
    }

    @Transactional
    public void create(ProviderDTO dto) {
        Provider oldObject = repo.findOneByName(dto.getName());
        if(oldObject != null)
        {
            logger.info("Object with name: "+ dto.getName()+"already exists");
            throw new IllegalArgumentException("Object with name: "+ dto.getName()+"already exists");
        }
        Provider entity = new Provider();
        BeanUtils.copyProperties(dto, entity);
        repo.save(entity);
    }

    @Transactional
    public void update(Long id, ProviderDTO dto) {
        Provider entity = repo.getOne(id);
        if (entity != null) {
            BeanUtils.copyProperties(dto, entity, "id");
            repo.save(entity);
        }
    }

    @Transactional
    public List<Provider> getByType(String type) {
        return repo.findAllByType(type);
    }

    @Transactional
    public boolean addService(Long servId, Long provId, Double price)
    {
        Services serv = servService.getOne(servId);
        if(serv == null)
        {
            logger.info("service: "+ servId+"not found");
            return false;
        }
        Provider provider = repo.findOne(provId);
        if(provider == null)
        {
            logger.info("provider: "+ provId+"not found");
            return false;
        }
        provider.addService(serv, price);
        return true;
    }

    @Transactional
    public void delete(Long id) {
        repo.delete(id);
    }

}
