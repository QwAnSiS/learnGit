package magiccube;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class OneIsManyController implements Initializable {

    @FXML
    private TextArea TextFieldOneIsMany;

    @FXML
    private TextField ResultOneIsMany;
    
    @FXML
    private void ClickOneIsMany(ActionEvent event) {
        Random rnd = new Random(System.currentTimeMillis());
        String strIn = TextFieldOneIsMany.getText();
        if(strIn.length()==0){ 
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Введите текст");
            alert.showAndWait();
            return;
        }
        String arrWord[] = strIn.split("\n");
        
        ResultOneIsMany.setText(arrWord[rnd.nextInt(arrWord.length)]);
    }
    
    @FXML
    void GoMenu(ActionEvent event) {
         MagicCube.setRootLayoutInStage();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
