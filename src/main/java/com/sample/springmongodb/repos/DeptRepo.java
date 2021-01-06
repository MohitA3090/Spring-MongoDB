package com.sample.springmongodb.repos;

import com.sample.springmongodb.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptRepo extends MongoRepository<Department,String> {
    
    @Query(value = "{'employees.ename': ?0}", fields = "{'employees': 0}")
    Department findDepartmentByEmployeeName(String ename);
    
    List<Department> findDepartmentByName(String name);
}
