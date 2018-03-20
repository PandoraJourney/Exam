package lt.akademija.service;

import lt.akademija.model.entity.Provider;
import lt.akademija.model.entity.Services;
import lt.akademija.model.dto.ProductDTO;
import lt.akademija.repository.ServicesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServicesService {

    private static Logger logger = LogManager.getLogger(Provider.class);

    @Autowired
    private ServicesRepository repo;
//
//    @Autowired(required = false)
//    private ProductDTO dto;

    @Transactional
    public List<? extends Services> getAll() {
        return repo.findAll();
    }

    @Transactional
    public Services getOne(Long id) {
        return repo.getOne(id);
    }

    @Transactional
    public void create(Services dto) {
//        if(this.dto != null)
//        {
//            logger.info("DTO is still alive");
//        }
        Services entity = new Services();
        BeanUtils.copyProperties(dto, entity);
        repo.save(entity);
    }

    @Transactional
    public void update(Long id, Services dto) {
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
