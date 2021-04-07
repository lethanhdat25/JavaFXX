package project.TheSV;


import java.util.ArrayList;

public interface DataAccessObject<S>{
    ArrayList<S> getList();
    ArrayList<S> Tim(String ten);
    boolean Xoa(S s);
    boolean Luu(Integer maThe,String name, String sdt, String diachi, String ngayTao, String ngayHH, String ngaySinh, String sex);

}
