package model;

public class Employee {

    private int maNhanVien;
    private String name;
    private String date;

    private String CMND;
    private String SDT;
    private String email;
    private String address;
    private double salary;
    private String ma_vi_tri;
    private String ma_trinh_do;
    private String ma_bo_phan;

    public Employee() {
    }

    public Employee(int maNhanVien, String name, String date, String CMND, String SDT, String email, String address, double salary, String ma_vi_tri, String ma_trinh_do, String ma_bo_phan) {
        this.maNhanVien = maNhanVien;
        this.name = name;
        this.date = date;
        this.CMND = CMND;
        this.SDT = SDT;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.ma_vi_tri = ma_vi_tri;
        this.ma_trinh_do = ma_trinh_do;
        this.ma_bo_phan = ma_bo_phan;
    }

    public Employee(String name, String date, String CMND, String SDT, String email, String address, double salary, String ma_vi_tri, String ma_trinh_do, String ma_bo_phan) {
        this.name = name;
        this.date = date;
        this.CMND = CMND;
        this.SDT = SDT;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.ma_vi_tri = ma_vi_tri;
        this.ma_trinh_do = ma_trinh_do;
        this.ma_bo_phan = ma_bo_phan;
    }



    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getMa_vi_tri() {
        return ma_vi_tri;
    }

    public void setMa_vi_tri(String ma_vi_tri) {
        this.ma_vi_tri = ma_vi_tri;
    }

    public String getMa_trinh_do() {
        return ma_trinh_do;
    }

    public void setMa_trinh_do(String ma_trinh_do) {
        this.ma_trinh_do = ma_trinh_do;
    }

    public String getMa_bo_phan() {
        return ma_bo_phan;
    }

    public void setMa_bo_phan(String ma_bo_phan) {
        this.ma_bo_phan = ma_bo_phan;
    }
}
