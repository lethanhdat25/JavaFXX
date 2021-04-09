package project.quanlymuontra;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import project.Main;
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
    }
    public void Xoa(){
        Quanlymuontra layTen=tbView.getSelectionModel().getSelectedItem();
        ModelMuonTra modelTheSV=new ModelMuonTra();
        if (modelTheSV.Xoa(layTen)){
        }
        tbView.getItems().remove(layTen);
    }
    public void Tim(){
        dsTim.remove(0,dsTim.size());
        ModelMuonTra modelTheSV=new ModelMuonTra();
        dsTim.addAll(modelTheSV.Tim(nhapTen.getText()));
        System.out.println(dsTim.size());
        tbView.setItems(dsTim);
    }
    public void Home(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../quanlythuvien/project.fxml"));
            Main.menuStage.setTitle("Hello World");
            Main.menuStage.setScene(new Scene(root, 1283, 813));
            Main.menuStage.show();
        }
        catch (Exception e){

        }
    }
}
