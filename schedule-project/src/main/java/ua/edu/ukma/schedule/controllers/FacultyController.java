package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.schedule.model.Faculty;
import ua.edu.ukma.schedule.model.Student;
import ua.edu.ukma.schedule.services.FacultyService;
import ua.edu.ukma.schedule.services.StudentService;
import ua.edu.ukma.schedule.util.CustomResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/faculty")
@RequiredArgsConstructor
@Log4j2
public class FacultyController {

    private final FacultyService service;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public CustomResponse<Long> create(
            @RequestBody @Valid Faculty faculty
    ) {
        return CustomResponse.of(service.save(faculty).getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CustomResponse<Faculty> read(
            @PathVariable(value = "id") Long id
    ) {
        return CustomResponse.of(service.getById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public CustomResponse<Boolean> update(
            @RequestBody @Valid Faculty faculty
    ) {
        service.save(faculty);
        return CustomResponse.of(true);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public CustomResponse<Boolean> delete(
            @PathVariable(value = "id") Long id
    ) {
        service.delete(id);
        return CustomResponse.of(true);
    }
}
