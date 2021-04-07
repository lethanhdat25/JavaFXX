package project.Quanly;

public class TheSV {
    Integer maThe;
    String name;
    String sdt;
    String Diachi;
    String NgayTao;
    String NgayHH;
    String NgaySinh;
    String Sex;

    public TheSV(Integer maThe,String name, String sdt, String diachi, String ngayTao, String ngayHH, String ngaySinh, String sex) {
        this.maThe=maThe;
        this.name = name;
        this.sdt = sdt;
        Diachi = diachi;
        NgayTao = ngayTao;
        NgayHH = ngayHH;
        NgaySinh = ngaySinh;
        Sex = sex;
    }

    public Integer getMaThe() {
        return maThe;
    }

    public void setMaThe(Integer maThe) {
        this.maThe = maThe;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String ngayTao) {
        NgayTao = ngayTao;
    }

    public String getNgayHH() {
        return NgayHH;
    }

    public void setNgayHH(String ngayHH) {
        NgayHH = ngayHH;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }
}
