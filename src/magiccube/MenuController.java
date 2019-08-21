package magiccube;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.io.IOException;

public class MenuController implements Initializable {

    @FXML
    private void GoOneIsMany(ActionEvent event) {
        try{
         MagicCube.setScene("OneIsMany.fxml");
        } catch (IOException e){System.out.println("Не найден FXML OneIsMany: "+e);}
    }

    @FXML
    private void GoGenerationPassword(ActionEvent event) {
        try{
         MagicCube.setScene("RndPassFxml.fxml");
        } catch (IOException e){System.out.println("Не найден FXML RndPassFxml: "+e);}
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     
    
}
