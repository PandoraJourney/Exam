package lt.akademija.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.akademija.model.entity.User;
import lt.akademija.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@Api(value = "User")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/all")
    @ApiOperation(value = "Get all", notes = "Returns all")
    public List<User> getProducts() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get one", notes = "Returns a single one")
    public User getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create", notes = "Creates new")
    public void create(@RequestBody User dto) {
        service.create(dto);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Update product", notes = "Updates product information")
    public void update(@RequestBody User cmd, @PathVariable Long id) {
        service.update(id,cmd);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete product", notes = "Delete a single")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
