package magiccube;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;



public class RndPassFxmlController implements Initializable {
    
    @FXML
    private TextField textFieldResult;
    
    @FXML
    private TextField countNumber;
    
    @FXML
    private CheckBox checkBox_az;
    
    @FXML
    private CheckBox checkBox_AZ;
    
    @FXML
    private CheckBox checkBox_aya;
    
    @FXML
    private CheckBox checkBox_AYA;
    
    @FXML
    private CheckBox checkBox_09;
    
    @FXML
    private CheckBox checkBox_SpecShar;

    
    ArrayList<Character> listUseCharacter;
   
    @FXML
    private void getRandomPassword(ActionEvent event) {
        
        if(!(checkBox_az.isSelected()||checkBox_AZ.isSelected()||checkBox_aya.isSelected()||checkBox_AYA.isSelected()||
        checkBox_09.isSelected()||checkBox_SpecShar.isSelected())){
            textFieldResult.setText("Выберите символы");
            return;
        }
        
        if(countNumber.getText().length()==0){
              textFieldResult.setText("Введите кол-во символов");
              return;
            }
            
        listUseCharacter = new ArrayList();
        if(checkBox_az.isSelected())for (char c = 'a'; c <= 'z'; c++) {listUseCharacter.add(c);}
        if(checkBox_AZ.isSelected())for (char c = 'A'; c <= 'Z'; c++) {listUseCharacter.add(c);}
        if(checkBox_aya.isSelected())for (char c = 'а'; c <= 'я'; c++) {listUseCharacter.add(c);}
        if(checkBox_AYA.isSelected())for (char c = 'А'; c <= 'Я'; c++) {listUseCharacter.add(c);}
        if(checkBox_09.isSelected())for (char c = '0'; c <= '9'; c++) {listUseCharacter.add(c);}
        if(checkBox_SpecShar.isSelected()) {
            listUseCharacter.add('%');
            listUseCharacter.add('*');
            listUseCharacter.add(')');
            listUseCharacter.add('?');
            listUseCharacter.add('@');
            listUseCharacter.add('(');
            listUseCharacter.add('#');
            listUseCharacter.add('$');
            listUseCharacter.add('~');
        }
        
        int numberCharacter;
        try {
            
            numberCharacter = Integer.parseInt(countNumber.getText());
        }catch(NumberFormatException exc){
            textFieldResult.setText("Данные введены не корректно");
            return;
        }
          if(numberCharacter>1024){
             textFieldResult.setText("Не более 1024 символов");
             return;
            }
        
        Random rnd = new Random(System.currentTimeMillis());
        StringBuffer randomPassword = new StringBuffer();
        
        for (int i = 1; i <= numberCharacter; i++) {
           randomPassword=randomPassword.append(listUseCharacter.get(rnd.nextInt(listUseCharacter.size())));
        }
        textFieldResult.setText(randomPassword.toString());
    }
    
    @FXML
    void goMenu(ActionEvent event) {
        MagicCube.setRootLayoutInStage();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
