package com.sample.springmongodb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.springmongodb.model.Employee;
import com.sample.springmongodb.repos.EmployeeRepo;
import com.sample.springmongodb.service.SequenceGeneratorService;
import com.sample.springmongodb.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/app/v1")
public class EmployeeController {
    
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    
    @Autowired
    private EmployeeRepo employeeRepo;
    
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long eid) throws ResourceNotFoundException{
        Employee employee = employeeRepo.findById(eid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + eid));
        return ResponseEntity.ok().body(employee);
    }
    
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        return employeeRepo.save(employee);
    }
    
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long eid, @Valid @RequestBody Employee employee)
            throws ResourceNotFoundException{
        Employee employee1 = employeeRepo.findById(eid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + eid));
        
        employee1.setEmailId(employee.getEmailId());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        final Employee employee2 = employeeRepo.save(employee1);
        return ResponseEntity.ok(employee2);
    }
    
    @DeleteMapping("/employees/{id}")
    public Map<String,Boolean> deleteEmployee(@PathVariable(value = "id")Long eid) throws ResourceNotFoundException{
        Employee employee = employeeRepo.findById(eid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + eid));
        employeeRepo.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
}
