package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage menuStage ;
    public void start(Stage primaryStage) throws Exception{
        menuStage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("quanlythe/danhMucTheThuVien.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1283, 813));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
