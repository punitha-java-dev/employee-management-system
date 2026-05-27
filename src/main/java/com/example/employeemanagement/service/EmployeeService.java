package com.example.employeemanagement.service;


	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.employeemanagement.entity.Employee;
	import com.example.employeemanagement.repository.EmployeeRepository;

	@Service
	public class EmployeeService {

	    @Autowired
	    private EmployeeRepository repo;

	    // Save Employee
	    public Employee saveEmployee(Employee emp) {
	        return repo.save(emp);
	    }

	    // Get all employees
	    public List<Employee> getAllEmployees() {
	        return repo.findAll();
	    }

	    // Get employee by id
	    public Employee getEmployeeById(Long id) {
	        return repo.findById(id).orElse(null);
	    }

	    // Delete employee
	    public void deleteEmployee(Long id) {
	        repo.deleteById(id);
	    }
	    public Employee updateEmployee(Long id, Employee empDetails) {

	        Employee emp = repo.findById(id).orElse(null);

	        if (emp != null) {
	            emp.setName(empDetails.getName());
	            emp.setDepartment(empDetails.getDepartment());
	            emp.setSalary(empDetails.getSalary());
	            return repo.save(emp);
	        }

	        return null;
	    }
	}


