package project.quanlythuvien;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import project.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  {

    public void baocao() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../danhMucTT/danhMucThongTinSach.fxml"));
        Main.menuStage.setTitle("Hello World");
        Main.menuStage.setScene(new Scene(root, 1283, 813));
        Main.menuStage.show();
    }
    public  void muontra() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../quanlythe/danhMucTheThuVien.fxml"));
        Main.menuStage.setTitle("Hello World");
        Main.menuStage.setScene(new Scene(root, 1283, 813));
        Main.menuStage.show();
    }
    public void sinhvien() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../danhMucTT/danhMucThongTinSach.fxml"));
        Main.menuStage.setTitle("Hello World");
        Main.menuStage.setScene(new Scene(root, 1283, 813));
        Main.menuStage.show();
    }
    public  void sach()throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../danhMucTT/danhMucThongTinSach.fxml"));
        Main.menuStage.setTitle("Hello World");
        Main.menuStage.setScene(new Scene(root, 1283, 813));
        Main.menuStage.show();
    }
}
