package model;

public class Service {
//    select dv.ma_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,dv.so_nguoi_toi_da,kt.ten_kieu_thue,
//    ldv.ten_loai_dich_vu,dv.tieu_chuan_phong,dv.mo_ta_tien_nghi_khac,dv.dien_tich_ho_boi,dv.so_tang
//    from dich_vu dv
//    join kieu_thue kt
//    on dv.ma_kieu_thue= kt.ma_kieu_thue
//    join loai_dich_vu ldv
//    on dv.ma_loai_dich_vu= ldv.ma_loai_dich_vu;


    private int maDv;
    private String name;
    private String square;
    private double chiPhiThue;
    private int soNguoi;
    private String kieuThue;
    private String dichVu;
    private String standardRoom;
    private String diff;
    private  String squareOfSwin;
    private int soTang;

    public Service() {
    }

    public Service(int maDv, String name, String square, double chiPhiThue, int soNguoi, String kieuThue, String dichVu, String standardRoom, String diff, String squareOfSwin, int soTang) {
        this.maDv = maDv;
        this.name = name;
        this.square = square;
        this.chiPhiThue = chiPhiThue;
        this.soNguoi = soNguoi;
        this.kieuThue = kieuThue;
        this.dichVu = dichVu;
        this.standardRoom = standardRoom;
        this.diff = diff;
        this.squareOfSwin = squareOfSwin;
        this.soTang = soTang;
    }

    public int getMaDv() {
        return maDv;
    }

    public void setMaDv(int maDv) {
        this.maDv = maDv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public String getSquareOfSwin() {
        return squareOfSwin;
    }

    public void setSquareOfSwin(String squareOfSwin) {
        this.squareOfSwin = squareOfSwin;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }
}
