package project.Quanly;

public class Quanlymuontra {
    Integer id;
    String tennguoimuon;
    String sdt;
    String tensach;
    String ngaymuon;
    String ngaytra;

    public Quanlymuontra(Integer id, String tennguoimuon, String sdt, String tensach, String ngaymuon, String ngaytra) {
        this.id = id;
        this.tennguoimuon = tennguoimuon;
        this.sdt = sdt;
        this.tensach = tensach;
        this.ngaymuon = ngaymuon;
        this.ngaytra = ngaytra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTennguoimuon() {
        return tennguoimuon;
    }

    public void setTennguoimuon(String tennguoimuon) {
        this.tennguoimuon = tennguoimuon;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }
}
