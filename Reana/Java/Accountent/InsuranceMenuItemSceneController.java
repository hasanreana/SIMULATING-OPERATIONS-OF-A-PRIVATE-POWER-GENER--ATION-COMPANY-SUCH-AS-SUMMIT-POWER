/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Accountant;

import CommonScenes.StartSceneController;
import Users.Accountant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class InsuranceMenuItemSceneController implements Initializable {
    
    private Accountant accountant; 

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }

    public Accountant getAccountant() {
        return accountant;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void makeNewInsuranceOnClick(ActionEvent event) throws IOException {
       
        Parent parent = null;
        FXMLLoader accountantLoader = new FXMLLoader(getClass().getResource("CreateInsuranceRecordScene.fxml"));
        parent = (Parent) accountantLoader.load();
        Scene accountantScene = new Scene(parent);

        CreateInsuranceRecordSceneController d = accountantLoader.getController();
        d.setAccountant(this.accountant);

        Stage accountantStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        accountantStage.setScene(accountantScene);
        accountantStage.show();
    }

    @FXML
    private void viewPastInsuranceOnClick(ActionEvent event) throws IOException {
        Parent parent = null;
        FXMLLoader accountantLoader = new FXMLLoader(getClass().getResource("ViewInsuranceRecordScene.fxml"));
        parent = (Parent) accountantLoader.load();
        Scene accountantScene = new Scene(parent);

        ViewInsuranceRecordSceneController d = accountantLoader.getController();
        d.setAccountant(this.accountant);

        Stage accountantStage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        accountantStage.setScene(accountantScene);
        accountantStage.show();
    }

    @FXML
    private void BackOnClick(ActionEvent event) throws IOException {
            Parent parent = null;
        FXMLLoader accountantLoader = new FXMLLoader(getClass().getResource("AccountantDashboard.fxml"));
        parent = (Parent) accountantLoader.load();
        Scene accountantScene = new Scene(parent);

        AccountantDashboardController d = accountantLoader.getController();
        d.setAccountant(this.accountant);

        Stage accountantStage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        accountantStage.setScene(accountantScene);
        accountantStage.show();
    
    } 
    
}
