package ua.edu.ukma.schedule.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.schedule.annotation.LogParams;
import ua.edu.ukma.schedule.model.Staff;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.services.StaffService;
import ua.edu.ukma.schedule.util.CustomResponse;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
@Log4j2
@Tag(name = "StaffController", description = "Processing operations with staff")
public class StaffController {

    private final StaffService service;

    @Operation(summary = "Add new staff member",description = "Creates a new staff member")
    @PostMapping(value = "")
    public CustomResponse<User> create(@RequestBody @Valid Staff staff) {
        return CustomResponse.of(service.save(staff));
    }

    @Operation(summary = "Get a staff member", description = "Gets a staff member with given id")
    @GetMapping(value = "/{id}")
    @LogParams
    public CustomResponse<Staff> read(@PathVariable(value = "id") @Parameter(description = "Staff id") Long id) {
        return CustomResponse.of(service.getById(id));
    }

    @Operation(summary = "Get all staff members", description = "Gets all staff members")
    @GetMapping(value = "/")
    public CustomResponse<Collection<Staff>> getAll() {
        return CustomResponse.of(service.getAll());
    }

    @Operation(summary = "Update a staff member",description = "Updates a staff member")
    @PutMapping(value = "")
    public CustomResponse<Staff> update(@RequestBody @Valid Staff staff) {
        return CustomResponse.of(service.save(staff));
    }

    @Operation(summary = "Delete a staff member",description = "Deletes a staff member"
    )
    @DeleteMapping(value = "/{id}")
    public CustomResponse<Boolean> delete(@PathVariable(value = "id") @Parameter(description = "Staff member id") Long id) {
        service.delete(id);
        return service.existsById(id) ? CustomResponse.of(false) : CustomResponse.of(true);
    }


}
