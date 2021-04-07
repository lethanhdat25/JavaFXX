package project.Quanly;

public class ThongTinSach {
    Integer Masach;
    String  Tensach;
    String Theloai;
    String Tinhtrang;
    Integer Soluong;
    String MaNXB;
    Integer NamNXB;

    public ThongTinSach(Integer masach, String tensach, String theloai, String tinhtrang, Integer soluong, String maNXB, Integer namNXB) {
        Masach = masach;
        Tensach = tensach;
        Theloai = theloai;
        Tinhtrang = tinhtrang;
        Soluong = soluong;
        MaNXB = maNXB;
        NamNXB = namNXB;
    }

    public Integer getMasach() {
        return Masach;
    }

    public void setMasach(Integer masach) {
        Masach = masach;
    }

    public String getTensach() {
        return Tensach;
    }

    public void setTensach(String tensach) {
        Tensach = tensach;
    }

    public String getTheloai() {
        return Theloai;
    }

    public void setTheloai(String theloai) {
        Theloai = theloai;
    }

    public String getTinhtrang() {
        return Tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        Tinhtrang = tinhtrang;
    }

    public Integer getSoluong() {
        return Soluong;
    }

    public void setSoluong(Integer soluong) {
        Soluong = soluong;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String maNXB) {
        MaNXB = maNXB;
    }

    public Integer getNamNXB() {
        return NamNXB;
    }

    public void setNamNXB(Integer namNXB) {
        NamNXB = namNXB;
    }

}
