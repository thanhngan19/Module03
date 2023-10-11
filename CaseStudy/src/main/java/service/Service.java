package service;

import repository.IServiceRepository;
import repository.ServiceRepository;

import java.util.List;

public class Service implements IService {
    private IServiceRepository repo = new ServiceRepository();

    @Override
    public List<model.Service> findAll() {
        return repo.findAll();
    }

    @Override
    public void addNew(model.Service serive) {
    repo.addNew(serive);
    }

    @Override
    public List<String> ldv() {
        return repo.ldv();
    }

    @Override
    public List<String> tkt() {
        return repo.tkt();
    }
}
