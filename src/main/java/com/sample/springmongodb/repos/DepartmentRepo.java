package com.sample.springmongodb.repos;

import com.sample.springmongodb.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepo{
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Department> findAll(){
        return mongoTemplate.findAll(Department.class);
    }
    
    public Department save(Department department){
        mongoTemplate.save(department);
        return department;
    }
    
    public Department update(Department department){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(department.getDid()));
        Update update = new Update();
        update.set("dname", department.getDname());
        update.set("description",department.getDescription());
        return mongoTemplate.findAndModify(query, update, Department.class);
    }
    
    public List<Department> findDepartmentByName(String dname){
        Query query = new Query();
        query.addCriteria(Criteria.where("dname").is(dname));
        return mongoTemplate.find(query, Department.class);
    }
    
    public void deleteById(String did){
        Query query = new Query();
        query.addCriteria(Criteria.where("did").is(did));
        mongoTemplate.remove(query,Department.class);
    }
    
}
