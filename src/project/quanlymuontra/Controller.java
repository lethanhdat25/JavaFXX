package project.quanlymuontra;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import project.Quanly.Quanlymuontra;
import project.Quanly.TheSV;
import project.TheSV.ModelTheSV;
import project.sql_muontra.ModelMuonTra;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField tennguoimuon;
    public TextField sdt;
    public TextField tenSach;
    public TextField nhapTen;
    public TableView<Quanlymuontra> tbView;
    public TableColumn<Quanlymuontra,String> tbName;
    public TableColumn<Quanlymuontra,String> tbSdt;
    public TableColumn<Quanlymuontra,String> tbTenSach;
    public ObservableList<Quanlymuontra> ds= FXCollections.observableArrayList();
    public ObservableList<Quanlymuontra> dsTim= FXCollections.observableArrayList();
    public TableColumn<Quanlymuontra,String> tbNgayMuon;
    public TableColumn<Quanlymuontra,String> tbNgayTra;
    public DatePicker ngayMuon;
    public DatePicker ngayTra;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbName.setCellValueFactory(new PropertyValueFactory<Quanlymuontra,String>("tennguoimuon"));
        tbSdt.setCellValueFactory(new PropertyValueFactory<Quanlymuontra,String>("sdt"));
        tbTenSach.setCellValueFactory(new PropertyValueFactory<Quanlymuontra,String>("tensach"));
        tbNgayMuon.setCellValueFactory(new PropertyValueFactory<Quanlymuontra,String>("ngaymuon"));
        tbNgayTra.setCellValueFactory(new PropertyValueFactory<Quanlymuontra,String>("ngaytra"));
        try{
            ModelMuonTra modelMuonTra=new ModelMuonTra();
            ds.addAll(modelMuonTra.getList());
            tbView.setItems(ds);
        }catch (Exception e){

        }
    }
    public void Them(){
        String n=tennguoimuon.getText();
        String phone=sdt.getText();
        String tenS=tenSach.getText();
        LocalDate ngayM=ngayMuon.getValue();
        LocalDate ngayT=ngayTra.getValue();
        if(!n.isEmpty()&&!phone.isEmpty()&&!tenS.isEmpty()&&!ngayM.toString().isEmpty()&&!ngayT.toString().isEmpty()){
            Quanlymuontra ql=new Quanlymuontra(null,n,phone,tenS,ngayM.toString(),ngayT.toString());
            ds.add(ql);
            tbView.setItems(ds);
        }
    }
    public void Luu(){
        ModelMuonTra modelMuonTra=new ModelMuonTra();
        for (Quanlymuontra sv:
                ds) {
            if (!ds.contains(sv.getTennguoimuon())&&!ds.contains(sv.getSdt())&&!ds.contains(sv.getTensach())&& !ds.contains(sv.getNgaymuon())) {
                if (modelMuonTra.LuuMuonTra(null,sv.getTennguoimuon(), sv.getSdt(), sv.getTensach(), sv.getNgaymuon(), sv.getNgaytra())) {
                    System.out.println("Them Thong Cong");
                } else {
                    System.out.println("Them Thai Bai");
                }
            }
        }
    }
    public void Tim(){

    }
}
