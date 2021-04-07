package project.TheSV;

import project.Quanly.TheSV;
import project.config.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelTheSV implements DataAccessObject<TheSV> {
    @Override
    public ArrayList<TheSV> getList() {
        ArrayList<TheSV> dss=new ArrayList<>();
        try{
            Statement st= Connector.getInstance().getStatement();
            String txt_sql="select * from ThuVien_TheSV";
            ResultSet rs=st.executeQuery(txt_sql);
            while (rs.next()){
                TheSV sv=new TheSV(rs.getInt("id"),rs.getString("Ten"),rs.getString("SDT"),rs.getString("Diachi"),rs.getString("ngaytao"),rs.getString("Ngayhethan"),rs.getString("ngaysinh"),rs.getString("gioitinh"));
                dss.add(sv);
            }
        }catch (Exception e){

        }
        return dss;
    }

    @Override
    public boolean Xoa(TheSV theSV) {
        try {
            Statement st=Connector.getInstance().getStatement();
            String txt_sql = "delete from ThuVien_TheSV where id = "+theSV.getMaThe();
            st.execute(txt_sql);
            return true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public ArrayList<TheSV> Tim(String ten) {
        ArrayList<TheSV> dss= new ArrayList<>();
        // kiem tra xem co hay ko thi tra ve object
        try {
            String txt_sql = "select * from ThuVien_TheSV where Ten like '%"+ten+"'";
            Statement st = Connector.getInstance().getStatement();
            ResultSet rs = st.executeQuery(txt_sql);
            while (rs.next()){
                TheSV sv=new TheSV(rs.getInt("id"),rs.getString("Ten"),rs.getString("SDT"),rs.getString("Diachi"),rs.getString("ngaytao"),rs.getString("Ngayhethan"),rs.getString("ngaysinh"),rs.getString("gioitinh"));
                dss.add(sv);
            }
        }catch (Exception e){
        }
        return dss;
    }

    @Override
    public boolean Luu(Integer maThe,String name, String sdt, String diachi, String ngayTao, String ngayHH, String ngaySinh, String sex) {
        try {
            Statement st = Connector.getInstance().getStatement();
            String txt_sql = "insert into ThuVien_TheSV(id,Ten,SDT,Diachi,ngaysinh,gioitinh,ngaytao,ngayhethan) " +
                    "values("+maThe+",'"+name+"'"+",'"+sdt+"'"+",'"+diachi+"'"
            +",'"+ngaySinh+"'"+",'"+sex+"'"+",'"+ngayTao+"'"+",'"+ngayHH+"'"+")";
            st.execute(txt_sql);
            return  true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
