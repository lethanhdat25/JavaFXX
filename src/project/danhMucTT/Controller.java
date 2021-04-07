package project.danhMucTT;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import project.Quanly.TheSV;
import project.Quanly.ThongTinSach;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MS.setCellValueFactory(new PropertyValueFactory<ThongTinSach,Integer>("MaSach"));
        TS.setCellValueFactory(new PropertyValueFactory<ThongTinSach,String>("Tensach"));
        TL.setCellValueFactory(new PropertyValueFactory<ThongTinSach,String>("Theloai"));
        TT.setCellValueFactory(new PropertyValueFactory<ThongTinSach,String>("Tinhtrang"));
        SL.setCellValueFactory(new PropertyValueFactory<ThongTinSach,Integer>("Soluong"));
        MNXB.setCellValueFactory(new PropertyValueFactory<ThongTinSach,String>("MaNXB"));
        NNXB.setCellValueFactory(new PropertyValueFactory<ThongTinSach,String>("NamNXB"));
    }
    public static Integer IdSach;
    public TextField Masach;
    public TextField Tensach;
    public TextField Theloai;
    public TextField Tinhtrang;
    public TextField Soluong;
    public TextField MaNXB;
    public TextField NamNXB;
    public TextField Search;
    ObservableList<ThongTinSach> ds = FXCollections.observableArrayList();
    public TableView<ThongTinSach> tbView;
    public TableColumn<ThongTinSach,Integer> MS;
    public TableColumn<ThongTinSach,String> TS;
    public TableColumn<ThongTinSach,String> TL;
    public TableColumn<ThongTinSach,String> TT;
    public TableColumn<ThongTinSach,Integer> SL;
    public TableColumn<ThongTinSach,String> MNXB;
    public TableColumn<ThongTinSach,String> NNXB;

    public void add(){
        String ts = Tensach.getText();
        String tl = Theloai.getText();
        String tt = Tinhtrang.getText();
        Integer sl = Integer.parseInt(Soluong.getText()) ;
        String mnxb = MaNXB.getText();
        Integer nnxb = Integer.parseInt(NNXB.getText());
        if (ts!=null && tl!=null && tt!=null && sl!=null && mnxb!=null && nnxb!=null ){
            ThongTinSach tts = new ThongTinSach(1,ts,tl,tt,sl,mnxb,nnxb);
            ds.add(tts);
            tbView.setItems(ds);
        }
    }
    public void remove(ActionEvent actionEvent){
        ThongTinSach getName = tbView.getSelectionModel().getSelectedItem();
        ObservableList<ThongTinSach> allThe;
        ObservableList<ThongTinSach> SingleThe;
        allThe=tbView.getItems();
        SingleThe=tbView.getSelectionModel().getSelectedItems();
        SingleThe.forEach(allThe::remove);
    }
    public void save(){

    }
}

