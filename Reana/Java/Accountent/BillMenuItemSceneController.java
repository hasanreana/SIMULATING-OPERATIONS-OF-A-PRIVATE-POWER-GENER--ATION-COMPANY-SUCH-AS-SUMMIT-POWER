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
public class BillMenuItemSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
   
            
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
private Accountant accountant; 

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
        System.out.println("Bill menu:"+accountant.toString());
    }

    public Accountant getAccountant() {
        return accountant;
    }
    @FXML
    private void OnClickCreateNewBillButton(ActionEvent event) throws IOException {
         Parent parent = null;
        FXMLLoader accountantLoader = new FXMLLoader(getClass().getResource("MakeABillScene.fxml"));
        parent = (Parent) accountantLoader.load();
        Scene accountantScene = new Scene(parent);

        MakeABillSceneController d = accountantLoader.getController();
        d.setAccountant(this.accountant);

        Stage accountantStage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        accountantStage.setScene(accountantScene);
        accountantStage.show();
    }

    @FXML
    private void onClickUpdatePendingBillStatusButton(ActionEvent event) throws IOException {
        Parent parent = null;
        FXMLLoader accountantLoader = new FXMLLoader(getClass().getResource("UpdateBillStatusScene.fxml"));
        parent = (Parent) accountantLoader.load();
        Scene accountantScene = new Scene(parent);

        UpdateBillStatusSceneController d = accountantLoader.getController();
        d.setAccountant(this.accountant);

        Stage accountantStage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        accountantStage.setScene(accountantScene);
        accountantStage.show();
    }

    @FXML
    private void OnClickViewPastRecordsButton(ActionEvent event) throws IOException {
         Parent parent = null;
        FXMLLoader accountantLoader = new FXMLLoader(getClass().getResource("ViewBillRecordsScene.fxml"));
        parent = (Parent) accountantLoader.load();
        Scene accountantScene = new Scene(parent);

        ViewBillRecordsSceneController d = accountantLoader.getController();
        d.setAccountant(this.accountant);

        Stage accountantStage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        accountantStage.setScene(accountantScene);
        accountantStage.show();
    }

   
    @FXML
    private void onActionChartButton(ActionEvent event) throws IOException {
       Parent parent = null;
        FXMLLoader accountantLoader = new FXMLLoader(getClass().getResource("SeeMedicineBillChartReport.fxml"));
        parent = (Parent) accountantLoader.load();
        Scene accountantScene = new Scene(parent);

        SeeMedicineBillChartReportController d = accountantLoader.getController();
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
