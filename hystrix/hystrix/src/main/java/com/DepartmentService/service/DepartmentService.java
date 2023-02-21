package com.DepartmentService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DepartmentService.entity.Department;
import com.DepartmentService.repository.DepartmentRepository;

import lombok.extern.java.Log;

import org.slf4j.Logger;
 
@Service
public class DepartmentService {
 

	 @Autowired
	    private DepartmentRepository departmentRepository;

	    public Department saveDepartment(Department department) {
	         
	        return departmentRepository.save(department);
	    }

	    public Department findDepartmentById(Long departmentId) {

	        return departmentRepository.findByDepartmentId(departmentId);
	    }
	
	

	 
	

}
