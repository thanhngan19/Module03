package service;

import model.Employee;
import repository.EmployeeRepository;
import repository.IEmployeeRepository;

import java.util.ArrayList;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository service= new EmployeeRepository();
    @Override
    public ArrayList<Employee> findAll() {
        return service.findAll();
    }

    @Override
    public void edit(Employee employee) {
        service.edit(employee);
    }

    @Override
    public   void addNewEmployee(Employee employee) {
        service.addNewEmployee(employee);
    }



    @Override
    public Employee findById(int id) {
        return service.findById(id);
    }

    @Override
    public ArrayList<String> seViTri() {
        return service.seViTri();
    }

    @Override
    public ArrayList<String> seBoPhan() {
        return service.seBoPhan();
    }

    @Override
    public ArrayList<String> setrinhDo() {
        return service.setrinhDo();
    }

    @Override
    public void deleteEmployee(int id) {
        service.deleteEmployee(id);
    }

    @Override
    public ArrayList<Employee> searchByName(String url) {
        return service.searchByName(url);
    }
}
