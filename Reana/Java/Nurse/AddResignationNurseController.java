/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Nurse;

import Users.Nurse;
import Users.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AddResignationNurseController implements Initializable {
  
 private Nurse nurse;
    @FXML
    private TextArea resignationTextArea;
    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
    /**
     * Initializes the controller class.
     */
    Alert unfill = new Alert(Alert.AlertType.WARNING, "FILL UP EVERYTHING");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addResignationOnClick(ActionEvent event) {
          String resignation = resignationTextArea.getText();
        if (resignation.isEmpty()) {unfill.show(); return;}
        
         Boolean addStatus = User.addNewResignation(this.nurse.getID(),resignation);
        if (addStatus) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("New Resignation added");
            a.showAndWait();
        }
    }
    
}
