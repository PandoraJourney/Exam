package lt.akademija.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.akademija.model.dto.ProviderDTO;
import lt.akademija.model.entity.Provider;
import lt.akademija.service.ProviderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@Api(value = "provider")
@RequestMapping(value = "api/provider")
@CrossOrigin(origins = "http://localhost:3000")
public class ProviderController {

    @Autowired
    private ProviderService service;

    //The only place prototype bean is used
    @Autowired (required = false)
    private ProviderDTO dto;

    @GetMapping(value = "/all")
    @ApiOperation(value = "Get all", notes = "Returns all")
    public List<? extends Provider> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get one", notes = "Returns a single one")
    public ProviderDTO getOne(@PathVariable Long id) {

        BeanUtils.copyProperties(service.getOne(id), this.dto);
        return this.dto;
    }

    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create", notes = "Creates new")
    public void create(@RequestBody ProviderDTO dto) {

        service.create(dto);
    }


    @GetMapping("/all/{type}")
    @ApiOperation(value = "Get all by type", notes = "Returns a single one")
    public List<ProviderDTO> getOne(@PathVariable String type) {
        return service.getByType(type).stream().map(ProviderDTO::new).collect(Collectors.toList());
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Update product", notes = "Updates product information")
    public void update(@RequestBody ProviderDTO cmd, @PathVariable Long id) {
        service.update(id,cmd);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete product", notes = "Delete a single")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
