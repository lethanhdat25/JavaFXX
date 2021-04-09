package project.danhMucTT;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import project.Main;
import project.Quanly.TheSV;
import project.Quanly.ThongTinSach;
import project.TheSV.ModelTheSV;
import project.sach.ModelSach;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TS.setCellValueFactory(new PropertyValueFactory<ThongTinSach,String>("Tensach"));
        TL.setCellValueFactory(new PropertyValueFactory<ThongTinSach,String>("Theloai"));
        TT.setCellValueFactory(new PropertyValueFactory<ThongTinSach,String>("Tinhtrang"));
        SL.setCellValueFactory(new PropertyValueFactory<ThongTinSach,Integer>("Soluong"));
        MNXB.setCellValueFactory(new PropertyValueFactory<ThongTinSach,String>("MaNXB"));
        NNXB.setCellValueFactory(new PropertyValueFactory<ThongTinSach,Integer>("NamNXB"));
        try{
            ModelSach modelSach=new ModelSach();
            ds.addAll(modelSach.getList());
            tbView.setItems(ds);
        }catch (Exception e){

        }
    }
    public Text thongbao;
    public TextField Tensach;
    public TextField Theloai;
    public TextField Tinhtrang;
    public TextField Soluong;
    public TextField MaNXB;
    public TextField NamNXB;
    public TextField Search;
    ObservableList<ThongTinSach> ds = FXCollections.observableArrayList();
    ObservableList<ThongTinSach> dsSearch = FXCollections.observableArrayList();
    public TableView<ThongTinSach> tbView;
    public TableColumn<ThongTinSach,String> TS;
    public TableColumn<ThongTinSach,String> TL;
    public TableColumn<ThongTinSach,String> TT;
    public TableColumn<ThongTinSach,Integer> SL;
    public TableColumn<ThongTinSach,String> MNXB;
    public TableColumn<ThongTinSach,Integer> NNXB;
    public void add(){
        String ts = Tensach.getText();
        String tl = Theloai.getText();
        String tt = Tinhtrang.getText();
        Integer sl = Integer.parseInt(Soluong.getText()) ;
        String mnxb = MaNXB.getText();
        Integer nnxb = Integer.parseInt(NamNXB.getText());
        if (!ts.isEmpty() && !tl.isEmpty() && !tt.isEmpty() && sl != null && !mnxb.isEmpty() && nnxb != null ){
                ThongTinSach tts = new ThongTinSach(null,ts,tl,tt,sl,mnxb,nnxb);
                ds.add(tts);
                tbView.setItems(ds);
                try {
                    ModelSach modelSach=new ModelSach();
                    for (ThongTinSach x:
                            ds) {
                        if(modelSach.save(x.getMasach(),x.getTensach(),x.getTheloai(),x.getTinhtrang(),x.getSoluong(),x.getMaNXB(),x.getNamNXB())){
                            System.out.println("Them Thanh Cong");
                        }else {
                            System.out.println("Them Thai Bai");
                        }
                    }
                }catch (Exception e){}

            Tensach.setText("") ;
            Theloai.setText("") ;
            Tinhtrang.setText("") ;
            Soluong.setText("") ;
            MaNXB.setText("") ;
            NamNXB.setText("") ;
        }else {
            thongbao.setText("Bạn phải nhập thông tin");
        }
    }
    public void remove(ActionEvent actionEvent){
        ThongTinSach layTen = tbView.getSelectionModel().getSelectedItem();
        ModelSach modelSach = new ModelSach();
        if (modelSach.remove(layTen)){
        }
        tbView.getItems().remove(layTen);
    }

    public void search(){
        dsSearch.remove(0,dsSearch.size());
        ModelSach modelSach = new ModelSach();
        dsSearch.addAll(modelSach.Search(Search.getText()));
        tbView.setItems(dsSearch);
    }
    public void home() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../quanlythuvien/project.fxml"));
        Main.menuStage.setTitle("Hello World");
        Main.menuStage.setScene(new Scene(root, 1283, 813));
        Main.menuStage.show();
    }
}

