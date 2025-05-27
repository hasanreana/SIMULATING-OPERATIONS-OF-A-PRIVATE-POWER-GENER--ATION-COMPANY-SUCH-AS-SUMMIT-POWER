/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Nurse;

import Users.Doctor;
import Users.Nurse;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ContactDoctorSceneController implements Initializable {
  private Nurse nurse; 

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
    
    @FXML
    private ComboBox<Integer> chooseDoctorComboBox;
    @FXML
    private TextField enterRequestDetailsTextField;
    Alert unfill = new Alert(Alert.AlertType.WARNING, "FILL UP EVERYTHING");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          chooseDoctorComboBox.getItems().addAll(Doctor.loadDocIDs());
      
        // TODO
    }    


    @FXML
    private void onActionSendRequestButton(ActionEvent event) {
          Integer DocIdRead = chooseDoctorComboBox.getValue();
        if (DocIdRead==null) {unfill.show(); return;}
        String details = enterRequestDetailsTextField.getText();
        if (details.isEmpty()){unfill.show(); return;}
       
        
        Boolean addStatus = Nurse.addNewTask(DocIdRead, this.nurse.getID(), details );
        if (addStatus) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("request sent");
            a.showAndWait();
        }
    }
    
}
