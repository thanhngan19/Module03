package service;

import model.Customer;
import repository.CustomerRepository;
import repository.ICustomerRepository;

import java.util.ArrayList;

public class CustomerService implements ICustomerService {
    private ICustomerRepository repo = new CustomerRepository();

    @Override
    public ArrayList<Customer> findAll() {
        return repo.findAll();
    }

    @Override
    public void edit(Customer customer) {
     repo.edit(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
  repo.addCustomer(customer);
    }

    @Override
    public Customer findById(int id) {
        return repo.findById(id);
    }

    @Override
    public ArrayList<String> seTenLoaiKhach() {
        return repo.seTenLoaiKhach();
    }

    @Override
    public int selectmaLoaiKhach(String url) {
        return repo.selectmaLoaiKhach(url);
    }

    @Override
    public void deleteCustomer(int id) {
  repo.deleteCustomer(id);
    }

    @Override
    public ArrayList<Customer> searchByName(String url) {
        return repo.searchByName(url);
    }
}
