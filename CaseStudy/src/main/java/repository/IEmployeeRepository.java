package repository;

import model.Employee;

import java.util.ArrayList;

public interface IEmployeeRepository {
     ArrayList<Employee> findAll();
     void edit(Employee employee);
    void addNewEmployee(Employee employee);

      Employee findById(int id);
    ArrayList<String> seViTri();
    ArrayList<String> seBoPhan();
    ArrayList<String> setrinhDo();
    void deleteEmployee(int id);
    ArrayList<Employee> searchByName(String url);

}
