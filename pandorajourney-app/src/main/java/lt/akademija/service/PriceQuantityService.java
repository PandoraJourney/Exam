package lt.akademija.service;

import lt.akademija.model.entity.AbstractProduct;
import lt.akademija.model.entity.PriceQuantity;
import lt.akademija.model.entity.Tablet;
import lt.akademija.repository.PriceQuantityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PriceQuantityService {
    @Autowired
    private PriceQuantityRepository repo;

    @Transactional
    public List<PriceQuantity> getAll() {
        return repo.findAll();
    }

    @Transactional
    public PriceQuantity getOne(Long id) {
        return repo.getOne(id);
    }

    @Transactional
    public void create(PriceQuantity dto) {
        PriceQuantity entity = new PriceQuantity();
        BeanUtils.copyProperties(dto, entity);
        repo.save(entity);
    }

    @Transactional
    public void update(Long id, PriceQuantity dto) {
        PriceQuantity entity = repo.getOne(id);
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
