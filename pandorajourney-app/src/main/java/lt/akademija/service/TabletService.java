package lt.akademija.service;

import lt.akademija.model.entity.AbstractProduct;
import lt.akademija.model.entity.SimpleUser;
import lt.akademija.model.entity.Tablet;
import lt.akademija.model.entity.dto.ProductDTO;
import lt.akademija.repository.AbstractProductRepository;
import lt.akademija.repository.SimpleUserRepository;
import lt.akademija.repository.TabletRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TabletService {

    private static Logger logger = LogManager.getLogger(Tablet.class);

    @Autowired
    private TabletRepository repo;

    @Autowired(required = false)
    private ProductDTO dto;

    @Transactional
    public List<? extends AbstractProduct> getAll() {
        return repo.findAll();
    }

    @Transactional
    public AbstractProduct getOne(Long id) {
        return repo.getOne(id);
    }

    @Transactional
    public void create(AbstractProduct dto) {
        if(this.dto != null)
        {
            logger.info("DTO is still alive");
            logger.info(this.dto.getScreen());
        }
        Tablet entity = new Tablet();
        BeanUtils.copyProperties(dto, entity);
        repo.save(entity);
    }

    @Transactional
    public void update(Long id, AbstractProduct dto) {
        Tablet entity = repo.getOne(id);
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
