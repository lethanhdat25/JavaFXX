package project.quanlythe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import project.Main;
import project.Quanly.TheSV;
import project.TheSV.ModelTheSV;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbTen.setCellValueFactory(new PropertyValueFactory<TheSV,String>("name"));
        tbSdt.setCellValueFactory(new PropertyValueFactory<TheSV,String>("sdt"));
        tbDiachi.setCellValueFactory(new PropertyValueFactory<TheSV,String>("Diachi"));
        tbNT.setCellValueFactory(new PropertyValueFactory<TheSV,String>("NgayTao"));
        tbNH.setCellValueFactory(new PropertyValueFactory<TheSV,String>("NgayHH"));
        tbNS.setCellValueFactory(new PropertyValueFactory<TheSV,String>("NgaySinh"));
        tbSex.setCellValueFactory(new PropertyValueFactory<TheSV,String>("Sex"));
        try{
            ModelTheSV modelTheSV=new ModelTheSV();
            ds.addAll(modelTheSV.getList());
            tbView.setItems(ds);
        }catch (Exception e){

        }

    }
    public Text thongbao;
    public TextField TenSV;
    public TextField Sdt;
    public TextField Diachi;
    public TextField Tim;
    public DatePicker NgaySinh;
    public DatePicker NgayTao;
    public DatePicker NgayHH;
    public TextField Sex;
    ObservableList<TheSV> ds= FXCollections.observableArrayList();
    ObservableList<TheSV> dsTim= FXCollections.observableArrayList();
    public TableView<TheSV> tbView;
    public TableColumn<TheSV,String> tbTen;
    public TableColumn<TheSV,String> tbSex;
    public TableColumn<TheSV,String> tbSdt;
    public TableColumn<TheSV,String> tbNS;
    public TableColumn<TheSV,String> tbNT;
    public TableColumn<TheSV,String> tbNH;
    public static TheSV edit;
    public TableColumn<TheSV,String> tbDiachi;

    public void Them(){
        thongbao.setText("");
        String n=TenSV.getText();
        String sdt=Sdt.getText();
        String dC=Diachi.getText();
        LocalDate nS=NgaySinh.getValue();
        LocalDate nT=NgayTao.getValue();
        LocalDate nHH=NgayHH.getValue();
        String sex=Sex.getText();
        if (!n.isEmpty()&&!sdt.isEmpty()&&!dC.isEmpty()&&!nT.toString().isEmpty()&&!nHH.toString().isEmpty()&&!nS.toString().isEmpty()&&!sex.isEmpty()){
            TheSV tSV = new TheSV(null, n, sdt, dC, nT.toString(), nHH.toString(), nS.toString(), sex);
            ds.add(tSV);
            tbView.setItems(ds);
            TenSV.setText("");
            Sdt.setText("");
            Diachi.setText("");
            Sex.setText("");
        }else{
            thongbao.setText("Ban phai nhap thong tin day du!");
        }

    }
    public void Xoa(){
        TheSV layTen=tbView.getSelectionModel().getSelectedItem();
        TenSV.setText(layTen.getName());
        ModelTheSV modelTheSV=new ModelTheSV();
        if (modelTheSV.Xoa(layTen)){
        }
        tbView.getItems().remove(layTen);
    }
    public void Luu(){
        ModelTheSV modelTheSV=new ModelTheSV();
        for (TheSV sv:
                ds) {
            if(modelTheSV.Luu(sv.getMaThe(),sv.getName(),sv.getSdt(),sv.getDiachi(),sv.getNgayTao(),sv.getNgayHH(),sv.getNgaySinh(),sv.getSex())){
            }
        }
    }
    public void Tim(){
        dsTim.remove(0,dsTim.size());
        ModelTheSV modelTheSV=new ModelTheSV();
        dsTim.addAll(modelTheSV.Tim(Tim.getText()));
        tbView.setItems(dsTim);
    }
    public void thayDoi(){

    }
    public void Thoat() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../quanlythuvien/project.fxml"));
        Main.menuStage.setTitle("Hello World");
        Main.menuStage.setScene(new Scene(root, 1283, 813));
        Main.menuStage.show();
    }
}
