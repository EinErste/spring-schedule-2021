package ua.edu.ukma.schedule.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.schedule.annotation.LogExecutionTime;
import ua.edu.ukma.schedule.annotation.LogParams;
import ua.edu.ukma.schedule.model.Faculty;
import ua.edu.ukma.schedule.services.FacultyService;
import ua.edu.ukma.schedule.util.CustomResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/faculty")
@Log4j2
@Tag(name = "FacultyController", description = "Processing operations with faculties")
public class FacultyController {

    private final FacultyService service;

    @Autowired
    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @Operation(
            summary = "Add new faculty",
            description = "Let add a new faculty"
    )
    @PostMapping(value = "/")
    public CustomResponse<Long> create(@RequestBody @Valid Faculty faculty) {
        return CustomResponse.of(service.save(faculty).getId());
    }

    @Operation(
            summary = "Get a faculty",
            description = "Get a faculty with given id"
    )
    @GetMapping(value = "/{id}")
    @LogExecutionTime
    public CustomResponse<Faculty> read(@PathVariable(value = "id") @Parameter(description = "Faculty id") Long id) {
        return CustomResponse.of(service.getById(id));
    }

    @Operation(
            summary = "Update a faculty",
            description = "Let update a faculty"
    )
    @PutMapping(value = "/")
    public CustomResponse<Boolean> update(@RequestBody @Valid Faculty faculty) {
        service.save(faculty);
        return CustomResponse.of(true);
    }

    @Operation(
            summary = "Delete a faculty",
            description = "Let delete a faculty"
    )
    @DeleteMapping(value = "/{id}")
    public CustomResponse<Boolean> delete(@PathVariable(value = "id") @Parameter(description = "Faculty id") Long id) {
        service.delete(id);
        return CustomResponse.of(true);
    }
}
