package lt.akademija.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.akademija.model.entity.AbstractProduct;
import lt.akademija.model.entity.SimpleUser;
import lt.akademija.model.entity.Tablet;
import lt.akademija.model.entity.dto.ProductDTO;
import lt.akademija.service.TabletService;
import lt.akademija.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value = "product")
@RequestMapping(value = "api/product")
public class ProductController {

    @Autowired
    private TabletService service;

    @Autowired (required = false)
    private ProductDTO dto;

    @GetMapping(value = "/all")
    @ApiOperation(value = "Get all", notes = "Returns all")
    public List<? extends AbstractProduct> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get one", notes = "Returns a single one")
    public AbstractProduct getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create", notes = "Creates new")
    public void create(@RequestBody Tablet dto) {
        BeanUtils.copyProperties(dto, this.dto);
        service.create(dto);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Update product", notes = "Updates product information")
    public void update(@RequestBody Tablet cmd, @PathVariable Long id) {
        service.update(id,cmd);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete product", notes = "Delete a single")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
