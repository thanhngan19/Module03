package repository;

import model.Employee;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EmployeeRepository implements IEmployeeRepository {
 public static Connection conn = BaseRepository.getConnection();
 public static final String SELECT="select nv.ma_nhan_vien,nv.ho_ten,nv.ngay_sinh,nv.so_cmnd,nv.luong,nv.so_dien_thoai,nv.email,nv.dia_chi,vt.ten_vi_tri,td.ten_trinh_do,bp.ten_bo_phan\n" +
         "     from nhan_vien nv \n" +
         "     join vi_tri vt\n" +
         "     on nv.ma_vi_tri=vt.ma_vi_tri\n" +
         "     join trinh_do td\n" +
         "     on nv.ma_trinh_do= td.ma_trinh_do\n" +
         "     join bo_phan bp\n" +
         "     on nv.ma_bo_phan= bp.ma_bo_phan ; ";

    public static final String FIND_BY_ID="select nv.ma_nhan_vien,nv.ho_ten,nv.ngay_sinh,nv.so_cmnd,nv.luong,nv.so_dien_thoai,nv.email,nv.dia_chi,vt.ten_vi_tri,td.ten_trinh_do,bp.ten_bo_phan\n" +
            "     from nhan_vien nv \n" +
            "     join vi_tri vt\n" +
            "     on nv.ma_vi_tri=vt.ma_vi_tri\n" +
            "     join trinh_do td\n" +
            "     on nv.ma_trinh_do= td.ma_trinh_do\n" +
            "     join bo_phan bp\n" +
            "     on nv.ma_bo_phan= bp.ma_bo_phan where nv.ma_nhan_vien=?; ";
 public static final String SELECT_MA_VI_TRI=" select vi_tri.ma_vi_tri from vi_tri where vi_tri.ten_vi_tri like?;";
 public static final String SELECT_MA_TRINH_DO="select trinh_do.ma_trinh_do from trinh_do where trinh_do.ten_trinh_do like?;";
 public static final String SELECT_MA_BO_PHAN="select bo_phan.ma_bo_phan from bo_phan where bo_phan.ten_bo_phan like ?;";
 public static final String INSERT="insert into nhan_vien set ho_ten=?,ngay_sinh=?,so_cmnd=?,luong=?,so_dien_thoai=?,email=?,dia_chi=?,ma_vi_tri=?,ma_trinh_do=?,ma_bo_phan=?";
 public static final String UPDATE ="update nhan_vien   set ho_ten=?,ngay_sinh=?,so_cmnd=?,luong=?,so_dien_thoai=?,email=?,dia_chi=?,ma_vi_tri=?,ma_trinh_do=?,ma_bo_phan=? where ma_nhan_vien=?";
    public static final String SEARCH_BY_NAME="select nv.ma_nhan_vien,nv.ho_ten,nv.ngay_sinh,nv.so_cmnd,nv.luong,nv.so_dien_thoai,nv.email,nv.dia_chi,vt.ten_vi_tri,td.ten_trinh_do,bp.ten_bo_phan\n" +
            "     from nhan_vien nv \n" +
            "     join vi_tri vt\n" +
            "     on nv.ma_vi_tri=vt.ma_vi_tri\n" +
            "     join trinh_do td\n" +
            "     on nv.ma_trinh_do= td.ma_trinh_do\n" +
            "     join bo_phan bp\n" +
            "     on nv.ma_bo_phan= bp.ma_bo_phan where nv.ho_ten like ?";
    @Override
    public void edit(Employee employee) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDate());
            ps.setString(3, employee.getCMND());
            ps.setString(4, String.valueOf(employee.getSalary()));
            ps.setString(5, employee.getSDT());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getAddress());
            ps.setString(8, String.valueOf(selectMaViTri(employee.getMa_vi_tri())));
            ps.setString(9, String.valueOf(selectMaTrinhDo(employee.getMa_trinh_do())));
            ps.setString(10, String.valueOf(selectMaBoPhan(employee.getMa_bo_phan())));
            ps.setInt(11,employee.getMaNhanVien());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


 @Override

    public ArrayList<Employee> findAll() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Connection conn = BaseRepository.getConnection();
        Employee employee ;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT);
            while(rs.next()) {
                 employee =new Employee();
                employee.setMaNhanVien(rs.getInt("ma_nhan_vien"));
                employee.setName(rs.getString("ho_ten"));
                employee.setDate(rs.getString("ngay_sinh"));
                employee.setCMND(rs.getString("so_cmnd"));
                employee.setSDT(rs.getString("so_dien_thoai"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("dia_chi"));
                employee.setSalary(Double.parseDouble(rs.getString("luong")));
                employee.setMa_vi_tri(rs.getString("ten_vi_tri"));
                employee.setMa_trinh_do(rs.getString("ten_trinh_do"));
                employee.setMa_bo_phan(rs.getString("ten_bo_phan"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }








    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try {
            PreparedStatement ps = conn.prepareStatement(FIND_BY_ID);
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employee = new Employee();
                employee.setMaNhanVien(rs.getInt("ma_nhan_vien"));
                employee.setName(rs.getString("ho_ten"));
                employee.setDate(rs.getString("ngay_sinh"));
                employee.setCMND(rs.getString("so_cmnd"));
                employee.setSDT(rs.getString("so_dien_thoai"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("dia_chi"));
                employee.setSalary(Double.parseDouble(rs.getString("luong")));
                employee.setMa_vi_tri(rs.getString("ten_vi_tri"));
                employee.setMa_trinh_do(rs.getString("ten_trinh_do"));
                employee.setMa_bo_phan(rs.getString("ten_bo_phan"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
    public int selectMaViTri(String url){
        int maViTri = 0;
        try {
            PreparedStatement ps= conn.prepareStatement(SELECT_MA_VI_TRI);
            ps.setString(1,url);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                maViTri= rs.getInt("ma_vi_tri");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maViTri;
    }
    public int selectMaTrinhDo(String url){
        int maTrinhDo = 0;
        try {
            PreparedStatement ps= conn.prepareStatement(SELECT_MA_TRINH_DO);
            ps.setString(1,url);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                maTrinhDo= rs.getInt("ma_trinh_do");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maTrinhDo;
    }
    public int selectMaBoPhan(String url){
        int maBoPhan = 0;
        try {
            PreparedStatement ps= conn.prepareStatement(SELECT_MA_BO_PHAN);
            ps.setString(1,url);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                maBoPhan= rs.getInt("ma_bo_phan");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maBoPhan;
    }
    public void addNewEmployee(Employee employee) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDate());
            ps.setString(3, employee.getCMND());
            ps.setString(4, String.valueOf(employee.getSalary()));
            ps.setString(5, employee.getSDT());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getAddress());
            ps.setString(8, String.valueOf(selectMaViTri(employee.getMa_vi_tri())));
            ps.setString(9, String.valueOf(selectMaTrinhDo(employee.getMa_trinh_do())));
            ps.setString(10, String.valueOf(selectMaBoPhan(employee.getMa_bo_phan())));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList<String> seViTri(){
        ArrayList<String> viTri= new ArrayList<String>();
      String SELECT_VI_TRI="select vi_tri.ten_vi_tri from vi_tri";
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_VI_TRI);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                viTri.add(rs.getString("ten_vi_tri"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return viTri;

    }
    public ArrayList<String> seBoPhan(){
        ArrayList<String> viTri= new ArrayList<String>();
        String SELECT_VI_TRI="select bo_phan.ten_bo_phan from bo_phan";
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_VI_TRI);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                viTri.add(rs.getString("ten_bo_phan"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return viTri;

    }
    public ArrayList<String> setrinhDo(){
        ArrayList<String> viTri= new ArrayList<String>();
        String SELECT_VI_TRI="select trinh_do.ten_trinh_do from trinh_do";
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_VI_TRI);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                viTri.add(rs.getString("ten_trinh_do"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return viTri;
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            PreparedStatement ps = conn .prepareStatement("delete from nhan_vien where nhan_vien.ma_nhan_vien=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList<Employee> searchByName(String url){
        Employee employee;
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try {
            PreparedStatement ps = conn.prepareStatement(SEARCH_BY_NAME);
            ps.setString(1, "%"+url+"%");
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                employee = new Employee();
                employee.setMaNhanVien(rs.getInt("ma_nhan_vien"));
                employee.setName(rs.getString("ho_ten"));
                employee.setDate(rs.getString("ngay_sinh"));
                employee.setCMND(rs.getString("so_cmnd"));
                employee.setSDT(rs.getString("so_dien_thoai"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("dia_chi"));
                employee.setSalary(Double.parseDouble(rs.getString("luong")));
                employee.setMa_vi_tri(rs.getString("ten_vi_tri"));
                employee.setMa_trinh_do(rs.getString("ten_trinh_do"));
                employee.setMa_bo_phan(rs.getString("ten_bo_phan"));
                employees.add(employee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;

    }
}
