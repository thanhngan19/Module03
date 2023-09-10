package repository;

import model.Product;

import java.util.ArrayList;

public interface IProductRepository {
    ArrayList<Product> findAll();
    Product selectByID(int id);
    int seCategory(String url);
    void Update(Product productUp,String url);
    void save(Product crProduct,String url);
    ArrayList search(String search);
    void delete(int id);
}
