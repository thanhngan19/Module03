package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService implements IProductService{
    IProductRepository productRepository= new ProductRepository();
    @Override
    public ArrayList<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product selectByID(int id) {
        return productRepository.selectByID(id);
    }

    @Override
    public int seCategory(String url) {
        return productRepository.seCategory(url);
    }

   public  ArrayList<String> seCategory(){
       return productRepository.seCategory();
   }





    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }
    @Override
    public Map<String,String> update(Product crHouse,String url){
        Map<String, String> map = new HashMap<String, String>();

        if(crHouse.getName_pro().isEmpty()){
            map.put("name_p", "tên không được để trống!!!!!");
        }
        else if(crHouse.getName_pro().length()<=3){
            map.put("name_p", "Tên bé hơn 3 ký tự!!!");
        }
        else if(crHouse.getName_pro().length()>50){
            map.put("name_p", "tên ít hơn 50 ký tự!!!!!");
        }
        else if(crHouse.getName_pro().matches("^[a-zA-Z]*")){
            map.put("name_p","tên ko chứa ký tự số!!!!!");
        }
        if(map.isEmpty()){
            productRepository.Update(crHouse,url);
        }
        return map;
    }
    @Override
    public Map<String,String> save(Product crHouse,String url){
        Map<String, String> map = new HashMap<String, String>();

        if(crHouse.getName_pro().isEmpty()){
            map.put("name_p", "tên không được để trống!!!!!");
        }
        else if(crHouse.getName_pro().length()<=3){
            map.put("name_p", "Tên bé hơn 3 ký tự!!!");
        }
        else if(crHouse.getName_pro().length()>50){
            map.put("name_p", "tên ít hơn 50 ký tự!!!!!");
        }
        else if(crHouse.getName_pro().matches("^[a-zA-Z]*")){
            map.put("name_p","tên ko chứa ký tự số!!!!!");
        }
        if(map.isEmpty()){
            productRepository.save(crHouse,url);
        }
        return map;
    }

    @Override
    public ArrayList search(String search) {
        return productRepository.search(search);
    }

}
