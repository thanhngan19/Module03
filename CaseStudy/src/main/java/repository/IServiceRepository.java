package repository;

import model.Service;

import java.util.List;

public interface IServiceRepository {
    List<Service> findAll();
    void addNew(Service serive);
    List<String> ldv();
    List<String> tkt();
}
