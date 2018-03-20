package lt.akademija.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.akademija.model.dto.ServiceDTO;
import lt.akademija.model.entity.Provider;
import lt.akademija.model.entity.Services;
import lt.akademija.service.ProviderService;
import lt.akademija.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "service")
@RequestMapping(value = "api/service")
@CrossOrigin(origins = "http://localhost:3000")
public class ServicesController {

    @Autowired
    private ServicesService service;

    @Autowired (required = false)
    private ServiceDTO dto;

    @GetMapping(value = "/all")
    @ApiOperation(value = "Get all", notes = "Returns all")
    public List<ServiceDTO> getAll() {
        return service.getAll().stream().map(ServiceDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get one", notes = "Returns a single one")
    public ServiceDTO getOne(@PathVariable Long id) {
        return new ServiceDTO(service.getOne(id));
    }


    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create", notes = "Creates new")
    public void create(@RequestBody ServiceDTO dto) {
//        BeanUtils.copyProperties(dto, this.dto);
        service.create(dto);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Update Services", notes = "Updates Services information")
    public void update(@RequestBody ServiceDTO cmd, @PathVariable Long id) {
        service.update(id,cmd);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete Services", notes = "Delete a single")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
