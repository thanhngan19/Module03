package service;

import model.Product;

import java.util.ArrayList;
import java.util.Map;

public interface IProductService {
    ArrayList<Product> findAll();
    Product selectByID(int id);
    int seCategory(String url);
//    void Update(Product productUp,String url);
    Map<String,String> save(Product crHouse,String url);
    ArrayList search(String search);
    void delete(int id);
    Map<String,String> update(Product crHouse, String url);
}
