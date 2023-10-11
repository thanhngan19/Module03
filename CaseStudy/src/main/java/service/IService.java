package service;

import model.Service;

import java.util.List;

public interface IService {
    List<model.Service> findAll();
    void addNew(Service serive);
    List<String> ldv();
    List<String> tkt();
}
