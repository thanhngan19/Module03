package service;

import model.Customer;

import java.util.ArrayList;

public interface ICustomerService {
    ArrayList<Customer> findAll();
    void edit(Customer customer);
    void addCustomer(Customer customer);

    Customer findById(int id);
    ArrayList<String> seTenLoaiKhach();
    int selectmaLoaiKhach(String url);
    void deleteCustomer(int id);
    ArrayList<Customer> searchByName(String url);
}
