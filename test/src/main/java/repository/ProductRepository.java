package repository;

import model.Product;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ProductRepository implements IProductRepository{
    public ArrayList<Product> findAll() {
        ArrayList<Product> result = new ArrayList<Product>();
        Connection conn = BaseRepository.getConnection();
        String SELECT="select product.id,product.name_pro, product.price,product.quantity,product.color,category.category from\n" +
                "product  join category \n" +
                "on product.id_category=category.id;";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT);
            while(rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName_pro(rs.getString("name_pro"));
                product.setPrice(Float.parseFloat(rs.getString("price")));
                product.setQuantity(Integer.parseInt(rs.getString("quantity")));
                product.setColor(rs.getString("color"));
                product.setCategory(rs.getString("category"));
                result.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public Product selectByID(int id) {
        Product product=new Product();
        Connection conn = BaseRepository.getConnection();
       String SLEECT_BY_ID="select product.id,product.name_pro, product.price,product.quantity,product.color,category.category from\n" +
               "product  join category \n" +
               "on product.id_category=category.id\n" +
               "where product.id="+id+";";
        try {
            PreparedStatement ps = conn.prepareStatement(SLEECT_BY_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product.setName_pro(rs.getString("name_pro"));
                product.setPrice(Float.parseFloat(rs.getString("price")));
                product.setQuantity(Integer.parseInt(rs.getString("quantity")));
                product.setColor(rs.getString("color"));
                product.setCategory(rs.getString("category"));
                product.setId(Integer.parseInt(rs.getString("id")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
    public int seCategory(String url) {
        Connection conn = BaseRepository.getConnection();
        String seCategory = "select category.id from category where category.category='" + url + "';";
        int id = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(seCategory);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
    public void Update(Product productUp,String url){
        Connection conn = BaseRepository.getConnection();
        int id_category=seCategory(url);
        String UPDATE="update product set name_pro='"+productUp.getName_pro()+"',price="+productUp.getPrice()+",quantity='"+productUp.getQuantity()+ "',id_category="+id_category+" where id="+productUp.getId()+";";
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Product crProduct,String url) {
        Connection conn = BaseRepository.getConnection();
        int id_category=seCategory(url);
        String INSERTINTO="insert into product set name_pro='"+crProduct.getName_pro()+"',price="+crProduct.getPrice()+",color='"+crProduct.getColor()+"',description='"+url+"',quantity="+crProduct.getQuantity()+",id_category="+id_category+";";
        try {
            PreparedStatement ps= conn.prepareStatement(INSERTINTO);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public ArrayList search(String search) {
        Connection conn = BaseRepository.getConnection();
        String SEARCH = "select product.name_pro, product.price,product.quantity,product.color,category.category from\n" +
        "product  join category \n" +
                "on product.id_category=category.id\n" +
                "where product.name_pro like '%" + search + "%';";
        ArrayList<Product> res = new ArrayList<Product>();
        try {
            PreparedStatement ps = conn.prepareStatement(SEARCH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setName_pro(rs.getString("name_pro"));
                product.setPrice(Float.parseFloat(rs.getString("price")));
                product.setQuantity(Integer.parseInt(rs.getString("quantity")));
                product.setColor(rs.getString("color"));
                product.setCategory(rs.getString("category"));
                res.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;

    }
    public void delete(int id){
        Connection conn = BaseRepository.getConnection();
        String DELETE="delete  from product where id="+id+";";
        try {
            PreparedStatement ps= conn.prepareStatement(DELETE);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
