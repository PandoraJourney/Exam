package lt.akademija.service;

import lt.akademija.model.entity.PriceQuantity;
import lt.akademija.model.entity.Provider;
import lt.akademija.repository.PriceQuantityRepository;
import lt.akademija.repository.ProviderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository repo;

    @Transactional
    public List<Provider> getAll() {
        return repo.findAll();
    }

    @Transactional
    public Provider getOne(Long id) {
        return repo.getOne(id);
    }

    @Transactional
    public void create(Provider dto) {
        Provider entity = new Provider();
        BeanUtils.copyProperties(dto, entity);
        repo.save(entity);
    }

    @Transactional
    public void update(Long id, Provider dto) {
        Provider entity = repo.getOne(id);
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
