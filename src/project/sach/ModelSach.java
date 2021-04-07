package project.sach;

import project.Quanly.ThongTinSach;
import project.config.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelSach implements DataAccessObject2<ThongTinSach> {
    @Override
    public ArrayList getList() {
        ArrayList<ThongTinSach> tts= new ArrayList<>();
        try{
            Statement st= Connector.getInstance().getStatement();
            String txt_sql="select * from thongtinsach";
            ResultSet rs=st.executeQuery(txt_sql);
            while (rs.next()){
                ThongTinSach ts = new ThongTinSach(rs.getInt("id"),rs.getString("tenSach"),rs.getString("theLoai"),rs.getString("tinhTrang"),rs.getInt("soLuong"),rs.getString("maNXB"),rs.getInt("namNXB"));
                tts.add(ts);
            }
        }catch (Exception e){

        }
        return tts;
    }

    @Override
    public ArrayList Search(String TenSach) {
        ArrayList<ThongTinSach> dss= new ArrayList<>();
        try {
            String txt_sql = "select * from thongtinsach where Tensach like '%"+TenSach+"'";
            Statement st = Connector.getInstance().getStatement();
            ResultSet rs = st.executeQuery(txt_sql);
            while (rs.next()){
                ThongTinSach thongTinSach=new ThongTinSach(rs.getInt("id"),rs.getString("tenSach"),rs.getString("theLoai"),rs.getString("tinhTrang"),rs.getInt("soLuong"),rs.getString("maNXB"),rs.getInt("namNXB"));
                dss.add(thongTinSach);
            }
        }catch (Exception e){
        }
        return dss;
    }

    @Override
    public boolean remove(ThongTinSach thongTinSach) {
        try {
            Statement st=Connector.getInstance().getStatement();
            String txt_sql = "delete from thongtinsach where tenSach = "+ thongTinSach.getTensach() ;
            st.execute(txt_sql);
            return true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean save(String tenSach, String theLoai, String tinhTrang, Integer soLuong, String maNXB, Integer namNXB) {
        try {
            Statement st = Connector.getInstance().getStatement();
            String txt_sql = "insert into thongtinsach(tenSach,theLoai,tinhTrang,soLuong,maNXB,namNXB) " +
                    "values('"+tenSach+"'"+",'"+theLoai+"'"+",'"+tinhTrang+"'"
                    +",'"+soLuong+"'"+",'"+maNXB+"'"+",'"+namNXB+"')";
            st.execute(txt_sql);
            return  true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}




