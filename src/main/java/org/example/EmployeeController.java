package org.example.controller;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // CREATE Employee
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    // GET All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // GET Employee By ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // UPDATE Employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    // DELETE Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return service.deleteEmployee(id);
    }
}