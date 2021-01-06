package com.sample.springmongodb.controller;

import com.sample.springmongodb.model.Department;
import com.sample.springmongodb.repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    
    @Autowired
    private DepartmentRepo departmentRepo;
    
    @GetMapping
    public List<Department> listDepts(){
        return departmentRepo.findAll();
    }
    
    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        departmentRepo.save(department);
        return department;
    }
    
    @PutMapping("/{deptId}")
    public Department saveDepartment(@RequestBody Department department, @PathVariable String deptId){
        department.setDid(deptId);
        departmentRepo.save(department);
        return department;
    }
    
    @DeleteMapping("/{deptId}")
    public String deleteDepartment(@PathVariable String deptId){
        departmentRepo.deleteById(deptId);
        return deptId;
    }
    
    @GetMapping("/{deptName}")
    public List<Department> findDepartment(@PathVariable String deptName){
        return departmentRepo.findDepartmentByName(deptName);
    }
    
//    @GetMapping("/{name}/emp")
//    public Department listDepartment(@PathVariable String name){
//        return departmentRepo.
//    }
}
