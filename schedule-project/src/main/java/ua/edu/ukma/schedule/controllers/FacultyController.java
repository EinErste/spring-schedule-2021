package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.schedule.model.Faculty;
import ua.edu.ukma.schedule.services.FacultyService;
import ua.edu.ukma.schedule.util.CustomResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/faculty")
@RequiredArgsConstructor
@Log4j2
public class FacultyController {

    private final FacultyService service;

    @PostMapping(value = "/")
    public CustomResponse<Long> create(@RequestBody @Valid Faculty faculty) {
        return CustomResponse.of(service.save(faculty).getId());
    }

    @GetMapping(value = "/{id}")
    public CustomResponse<Faculty> read(@PathVariable(value = "id") Long id) {
        return CustomResponse.of(service.getById(id));
    }

    @PutMapping(value = "/")
    public CustomResponse<Boolean> update(@RequestBody @Valid Faculty faculty) {
        service.save(faculty);
        return CustomResponse.of(true);
    }

    @DeleteMapping(value = "/{id}")
    public CustomResponse<Boolean> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return CustomResponse.of(true);
    }
}
