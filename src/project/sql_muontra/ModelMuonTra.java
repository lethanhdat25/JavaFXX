package project.sql_muontra;

import project.Quanly.Quanlymuontra;
import project.Quanly.TheSV;
import project.TheSV.DataAccessObject;
import project.config.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelMuonTra implements DataAccessObject {
    @Override
    public ArrayList<Quanlymuontra> getList() {
        ArrayList<Quanlymuontra> dss=new ArrayList<>();
        try{
            Statement st= Connector.getInstance().getStatement();
            String txt_sql="select * from ThuVien_MuonTra";
            ResultSet rs=st.executeQuery(txt_sql);
            while (rs.next()){
                Quanlymuontra sv=new Quanlymuontra(rs.getInt("id"),rs.getString("TenNguoiMuon"),rs.getString("Sdt"),rs.getString("TenSach"),rs.getString("NgayMuon"),rs.getString("NgayTra"));
                dss.add(sv);
            }
        }catch (Exception e){

        }
        return dss;
    }

    @Override
    public ArrayList<Quanlymuontra> Tim(String ten) {
        ArrayList<Quanlymuontra> dss= new ArrayList<>();
        // kiem tra xem co hay ko thi tra ve object
        try {
            String txt_sql = "select * from ThuVien_MuonTra where Ten like '%"+ten+"'";
            Statement st = Connector.getInstance().getStatement();
            ResultSet rs = st.executeQuery(txt_sql);
            while (rs.next()){
                Quanlymuontra sv=new Quanlymuontra(rs.getInt("id"),rs.getString("TenNguoiMuon"),rs.getString("Sdt"),rs.getString("TenSach"),rs.getString("NgayMuon"),rs.getString("NgayTra"));
                dss.add(sv);
            }
        }catch (Exception e){
        }
        return dss;
    }

    @Override
    public boolean Luu(Integer maThe, String name, String sdt, String diachi, String ngayTao, String ngayHH, String ngaySinh, String sex) {
        return false;
    }

    @Override
    public boolean LuuMuonTra(Integer id,String tennguoi, String sdt, String tensach, String ngaymuon, String ngaytra) {
        try {
            Statement st = Connector.getInstance().getStatement();
            String soluong_hientai="select soLuong from thongtinsach where tenSach like("+"'%"+tensach+"%'"+")";
            ResultSet rs=st.executeQuery(soluong_hientai);
            Integer x=0;
            while (rs.next()){
                x = rs.getInt("soLuong");
            }
            if (x>=2) {
                Statement stt1 = Connector.getInstance().getStatement();
                String txt_sql = "insert into ThuVien_MuonTra(id,TenNguoiMuon,Sdt,TenSach,NgayMuon,NgayTra) " +
                        "values("+id+",'"+ tennguoi + "','" + sdt + "'" + ",'" + tensach + "'" + ",'" + ngaymuon + "'"
                        + ",'" + ngaytra + "'" + ")";
                stt1.execute(txt_sql);
                Integer soluong_conlai=x-1;
                Statement stt2 = Connector.getInstance().getStatement();
                String update="UPDATE thongtinsach SET soLuong ="+soluong_conlai+" where tenSach like("+"'%"+tensach+"'"+")";
                stt2.execute(update);
                return true;
            }else {
                return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
