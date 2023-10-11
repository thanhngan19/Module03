package repository;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerRepository implements ICustomerRepository{
    static Connection conn = BaseRepository.getConnection();
    public static final String SELECT="select kh.ma_khach_hang, lk.ten_loai_khach,kh.ho_ten,kh.ngay_sinh,kh.gioi_tinh,kh.so_cmnd,kh.so_dien_thoai,kh.email,kh.dia_chi\n" +
            "  from khach_hang kh\n" +
            "  join loai_khach lk\n" +
            "  on kh.ma_loai_khach= lk.ma_loai_khach;";
    public static final String INSERT_INTO="insert into khach_hang set ten_loai_khach=?,ho_ten=?,ngay_sinh=?, gioi_tinh=?,so_cmnd=?,so_dien_thoai=?,email=?,dia_chi=?";
    public static final String UPDATE="update khach_hang set ma_loai_khach=?,ho_ten=?,ngay_sinh=?, gioi_tinh=?,so_cmnd=?,so_dien_thoai=?,email=?,dia_chi=? where ma_khach_hang=?";
    public static final String DELETE="delete from khach_hang where khach_hang.ma_khach_hang=?";
    public static final String SEARCH="select kh.ma_khach_hang, lk.ten_loai_khach,kh.ho_ten,kh.ngay_sinh,kh.gioi_tinh,kh.so_cmnd,kh.so_dien_thoai,kh.email,kh.dia_chi\n" +
            "  from khach_hang kh\n" +
            "  join loai_khach lk\n" +
            "  on kh.ma_loai_khach= lk.ma_loai_khach where kh.ho_ten like ?";
    public static final String FIND_BY_ID="select kh.ma_khach_hang, lk.ten_loai_khach,kh.ho_ten,kh.ngay_sinh,kh.gioi_tinh,kh.so_cmnd,kh.so_dien_thoai,kh.email,kh.dia_chi\n" +
            "  from khach_hang kh\n" +
            "  join loai_khach lk\n" +
            "  on kh.ma_loai_khach= lk.ma_loai_khach where kh.ma_khach_hang=?";
    public static final String SELCT_FROM_LOAI_KHACH= "select loai_khach.ten_loai_khach from loai_khach";
    public static final String SELECT_MA_LOAI_KHACH= "select loai_khach.ma_loai_khach from loai_khach where loai_khach.ten_loai_khach like?";


    @Override
    public ArrayList<Customer> findAll() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = null;
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                customer = new Customer();
                customer.setMaKH(rs.getInt("ma_khach_hang"));
                customer.setLoaiKH(rs.getString("ten_loai_khach"));
                customer.setName(rs.getString("ho_ten"));
                customer.setDate(rs.getString("ngay_sinh"));
                customer.setGender(rs.getInt("gioi_tinh"));
                customer.setCmnd(rs.getString("so_cmnd"));
                customer.setSdt(rs.getString("so_dien_thoai"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("dia_chi"));
                customers.add(customer);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public void edit(Customer customer) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, selectmaLoaiKhach(customer.getLoaiKH()));
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getDate());
            ps.setInt(4, customer.isGender());
            ps.setString(5, customer.getCmnd());
            ps.setString(6, customer.getSdt());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());
            ps.setInt(9, customer.getMaKH());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO);
            ps.setInt(1, selectmaLoaiKhach(customer.getLoaiKH()));
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getDate());
            ps.setInt(4, customer.isGender());
            ps.setString(5, customer.getCmnd());
            ps.setString(6, customer.getSdt());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Customer findById(int id) {
        Customer customer= null;
        try {
            PreparedStatement ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                customer = new Customer();
                customer.setMaKH(rs.getInt("ma_khach_hang"));
                customer.setLoaiKH(rs.getString("ten_loai_khach"));
                customer.setName(rs.getString("ho_ten"));
                customer.setDate(rs.getString("ngay_sinh"));
                customer.setGender(rs.getInt("gioi_tinh"));
                customer.setCmnd(rs.getString("so_cmnd"));
                customer.setSdt(rs.getString("so_dien_thoai"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("dia_chi"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }

    @Override
    public ArrayList<String> seTenLoaiKhach() {
        ArrayList<String> tenLoaiKhach = new ArrayList<String>();
        try {
            PreparedStatement ps  = conn.prepareStatement(SELCT_FROM_LOAI_KHACH);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                tenLoaiKhach.add(rs.getString("ten_loai_khach"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tenLoaiKhach;
    }

    @Override
    public int selectmaLoaiKhach(String url) {
        int maLoaiKhach=0;
        try {
            PreparedStatement ps= conn.prepareStatement(SELECT_MA_LOAI_KHACH);
            ps.setString(1,url);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                maLoaiKhach = rs.getInt("ma_loai_khach");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maLoaiKhach;
    }


    @Override
    public void deleteCustomer(int id) {
        try {
            PreparedStatement ps= conn.prepareStatement(DELETE);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ArrayList<Customer> searchByName(String url) {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = null;
        try {
            PreparedStatement ps = conn.prepareStatement(SEARCH);
            ps.setString(1,"%"+url+"%");
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                customer = new Customer();
                customer.setMaKH(rs.getInt("ma_khach_hang"));
                customer.setLoaiKH(rs.getString("ten_loai_khach"));
                customer.setName(rs.getString("ho_ten"));
                customer.setDate(rs.getString("ngay_sinh"));
                customer.setGender(rs.getInt("gioi_tinh"));
                customer.setCmnd(rs.getString("so_cmnd"));
                customer.setSdt(rs.getString("so_dien_thoai"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("dia_chi"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }



}
