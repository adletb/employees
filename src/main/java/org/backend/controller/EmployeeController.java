package org.backend.controller;

import org.backend.entity.City;
import org.backend.entity.Country;
import org.backend.entity.Employee;
import org.backend.repo.CityRepo;
import org.backend.repo.CountryRepo;
import org.backend.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private CityRepo cityRepo;

    @GetMapping("/employees")
    public List<Employee> fetchEmployees(){
        return employeeRepo.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@PathVariable long id){
        return employeeRepo.findById(id).orElse(null);
    }

    @GetMapping("/countries")
    public List<Country> fetchCountries(){
        return countryRepo.findAll();
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityRepo.findAll();
    }

    @GetMapping("/cities/{id}")
    public List<City> fetchCity(@PathVariable int id){
        List<City> cities = cityRepo.findByCountry(id);
        return cities;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee){
        Employee existingEmployee = employeeRepo.findById(employee.getId()).orElse(null);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPatronymic(employee.getPatronymic());
        existingEmployee.setPhoneNum(employee.getPhoneNum());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setCountry(employee.getCountry());
        existingEmployee.setCity(employee.getCity());
        employeeRepo.save(existingEmployee);
        return "Employee updated successfully!";
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee){
        employeeRepo.save(employee);
        return "Employee added successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id){
        employeeRepo.deleteById(id);
        return "employee removed!";
    }


}
