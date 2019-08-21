package magiccube;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MagicCube extends Application {
    
    private static Stage primaryStage;
    private static Scene mainScene;
    
    @Override
    public void start(Stage stage){
        primaryStage = stage;
        primaryStage.setTitle("Magic Cube");
        primaryStage.getIcons().add(new Image(MagicCube.class.getResourceAsStream("Q-MinWhite.png")));
        primaryStage.setResizable(false);
        initRootLayout();
        setRootLayoutInStage();
    }
    
    private void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MagicCube.class.getResource("Menu.fxml"));
            AnchorPane rootLayout =(AnchorPane) loader.load();
            mainScene = new Scene(rootLayout);
        }catch(IOException e){System.out.println(e);}
    }
    
    public static void setRootLayoutInStage(){
        primaryStage.setScene(mainScene);
        primaryStage.show();       
    }
    
    public static void setScene(AnchorPane anchorPane){
        primaryStage.setScene(new Scene(anchorPane));
    }
    
    public static void setScene(String nameFXML) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MagicCube.class.getResource(nameFXML));
        AnchorPane ap =(AnchorPane) loader.load();
        primaryStage.setScene(new Scene(ap));
    }
    
    public static Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
