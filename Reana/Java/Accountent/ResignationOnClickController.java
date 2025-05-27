/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Accountant;

import Users.Accountant;
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
public class ResignationOnClickController implements Initializable {
 private Accountant accountant;

    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
       
    }
    @FXML
    private TextArea resignationTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
Alert unfill = new Alert(Alert.AlertType.WARNING, "FILL UP EVERYTHING");
    @FXML
    private void addButtonOnClick(ActionEvent event) {
           String resignation = resignationTextArea.getText();
        if (resignation.isEmpty()) {unfill.show(); return;}
        
         Boolean addStatus = User.addNewResignation(this.accountant.getID(),resignation);
        if (addStatus) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("New Resignation added");
            a.showAndWait();
        }
    }

    @FXML
    private void switchToAddEmployeeScene(ActionEvent event) {
    }
    
}
